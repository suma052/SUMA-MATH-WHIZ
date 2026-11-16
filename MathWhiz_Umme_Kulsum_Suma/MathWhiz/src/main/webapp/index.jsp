<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html><html><head><title>Math Whiz - Welcome</title><link rel="stylesheet" href="css/style.css"></head>
<body><main class="container">
  <header><div class="logo">∑</div><h1>MATH WHIZ</h1><p>Java Web Application Development</p></header>
  <section class="panel center">
    <h2>Welcome to Math Whiz!</h2>
    <p>Test your mathematical skills with four exciting questions.</p>
    <p class="student"><b>Developed by:</b> Umme Kulsum (Suma)<br><b>ID:</b> IT24052</p>
    <% if (request.getAttribute("error") != null) { %><p class="error"><%= request.getAttribute("error") %></p><% } %>
    <form method="post" action="game">
      <input type="hidden" name="action" value="start">
      <label for="playerName">Enter Player Name</label>
      <input id="playerName" name="playerName" maxlength="100" required placeholder="Your name">
      <button type="submit">Start Game</button>
    </form>
    <a class="link" href="game?action=leaderboard">View Top 10 Leaderboard</a>
  </section>
  <footer>Difficulty: NORMAL · Maximum Score: 10</footer>
</main></body></html>
