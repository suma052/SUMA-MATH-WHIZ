<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%
List<String[]> scores = (List<String[]>) request.getAttribute("scores");
%>
<!DOCTYPE html><html><head><title>Math Whiz - Leaderboard</title><link rel="stylesheet" href="css/style.css"></head><body>
<main class="container"><header><div class="logo">🏆</div><h1>TOP 10 LEADERBOARD</h1><p>Highest scores first</p></header>
<section class="panel"><% if(scores == null || scores.isEmpty()) { %><p class="center">No scores yet. Be the first player!</p><% } else { %>
<div class="table-wrap"><table><thead><tr><th>Rank</th><th>Player</th><th>Score</th><th>Difficulty</th><th>Played At</th></tr></thead><tbody>
<% int rank=1; for(String[] row:scores) { %><tr><td><%= rank++ %></td><td><%= row[0] %></td><td><b><%= row[1] %>/10</b></td><td><%= row[2] %></td><td><%= row[3] %></td></tr><% } %>
</tbody></table></div><% } %>
<a class="button" href="<%= request.getContextPath() %>/">Back to Home</a></section></main></body></html>
