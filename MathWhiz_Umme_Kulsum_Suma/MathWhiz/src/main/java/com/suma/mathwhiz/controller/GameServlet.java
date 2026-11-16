package com.suma.mathwhiz.controller;

import com.suma.mathwhiz.dao.ScoreDAO;
import com.suma.mathwhiz.model.GameQuestion;
import com.suma.mathwhiz.model.GameResult;
import com.suma.mathwhiz.service.MathService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("leaderboard".equals(action)) {
            try {
                request.setAttribute("scores", new ScoreDAO().getTop10());
                request.getRequestDispatcher("/leaderboard.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new ServletException("Could not load leaderboard. Check database settings.", e);
            }
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("start".equals(action)) {
            String name = request.getParameter("playerName");
            if (name == null || name.trim().isEmpty() || name.trim().length() > 100) {
                request.setAttribute("error", "Please enter a name (maximum 100 characters).");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("playerName", name.trim());
            session.setAttribute("questions", makeQuestions());
            request.getRequestDispatcher("/game.jsp").forward(request, response);
            return;
        }

        if ("submit".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("questions") == null) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
            @SuppressWarnings("unchecked")
            List<GameQuestion> questions = (List<GameQuestion>) session.getAttribute("questions");
            int score = 0;
            boolean[] correct = new boolean[4];
            for (int i = 0; i < questions.size(); i++) {
                GameQuestion q = questions.get(i);
                correct[i] = MathService.isCorrect(request.getParameter("answer" + (i + 1)),
                        q.getExpectedAnswer(), q.isIntegerAnswer());
                if (correct[i]) score += q.getMarks();
            }

            String playerName = (String) session.getAttribute("playerName");
            try {
                new ScoreDAO().saveScore(playerName, score, "NORMAL");
            } catch (SQLException e) {
                request.setAttribute("dbError", "Score could not be saved. Check your MySQL connection and password.");
            }
            request.setAttribute("result", new GameResult(playerName, score));
            request.setAttribute("correct", correct);
            session.removeAttribute("questions");
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    private List<GameQuestion> makeQuestions() {
        List<GameQuestion> list = new ArrayList<>();
        int prime = 17;
        int a = 23, b = 6;
        int angle1 = 30, angle2 = 60;
        list.add(new GameQuestion("Is " + prime + " a prime number? Enter 1 for YES or 0 for NO.",
                "Prime", MathService.isPrime(prime), 2, true));
        list.add(new GameQuestion("Calculate " + a + " % " + b + ". Enter the integer remainder.",
                "Modulus", MathService.calculateMod(a, b), 2, true));
        list.add(new GameQuestion("Calculate sin(" + angle1 + "°).", "Trigonometry",
                MathService.calculateSin(angle1), 3, false));
        list.add(new GameQuestion("Calculate cos(" + angle2 + "°).", "Trigonometry",
                MathService.calculateCos(angle2), 3, false));
        return list;
    }
}
