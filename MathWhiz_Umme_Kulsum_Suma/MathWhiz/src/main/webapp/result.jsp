<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.suma.mathwhiz.model.GameResult" %>
<%
GameResult result = (GameResult) request.getAttribute("result");
boolean[] correct = (boolean[]) request.getAttribute("correct");
%>
<!DOCTYPE html><html><head><title>Math Whiz - Result</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="container"><header><div class="logo">∑</div><h1>GAME RESULT</h1></header><section class="panel center">
<% if (result != null) { %><h2>Well played, <%= result.getPlayerName() %>!</h2>
<div class="score"><%= result.getScore() %><small>/10</small></div>
<p>Your final score</p>
<ul class="result-list"><% for(int i=0;i<correct.length;i++){ %><li>Question <%= i+1 %>: <b class="<%= correct[i] ? "good" : "bad" %>"><%= correct[i] ? "Correct" : "Incorrect" %></b></li><% } %></ul>
<% } %>
<% if (request.getAttribute("dbError") != null) { %><p class="error"><%= request.getAttribute("dbError") %></p><% } else { %><p class="good">Your score has been saved (if database connection is configured).</p><% } %>
<a class="button" href="<%= request.getContextPath() %>/">Play Again</a>
<a class="link" href="game?action=leaderboard">View Leaderboard</a>
</section><footer>Umme Kulsum (Suma) · IT24052</footer></main></body></html>
