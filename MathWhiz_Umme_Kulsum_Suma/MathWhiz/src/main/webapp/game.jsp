<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List,com.suma.mathwhiz.model.GameQuestion" %>
<%
List<GameQuestion> questions = (List<GameQuestion>) session.getAttribute("questions");
String player = (String) session.getAttribute("playerName");
if (questions == null || player == null) { response.sendRedirect(request.getContextPath() + "/"); return; }
%>
<!DOCTYPE html><html><head><title>Math Whiz - Game</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="container"><header><div class="logo">∑</div><h1>MATH WHIZ</h1><p>Good luck, <%= player %>!</p></header>
<section class="panel"><h2>Your Challenge</h2><p>Answer all four questions. Total = 10 marks. Trigonometry answers may be rounded to 2 decimal places.</p>
<form method="post" action="game"><input type="hidden" name="action" value="submit">
<% for (int i=0; i<questions.size(); i++) { GameQuestion q=questions.get(i); %>
<div class="question"><div class="qhead"><b>Question <%= i+1 %></b><span><%= q.getMarks() %> marks</span></div>
<p><%= q.getPrompt() %></p>
<input type="text" name="answer<%= i+1 %>" required placeholder="Enter your answer" autocomplete="off">
</div><% } %>
<button type="submit">Submit Answers</button></form></section>
<footer>Player: <%= player %> · Difficulty: NORMAL</footer></main></body></html>
