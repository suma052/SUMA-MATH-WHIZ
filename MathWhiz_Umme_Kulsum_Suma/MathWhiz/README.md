# Umme Kulsum (Suma) – Math Whiz

**Student ID:** IT24052  
**Course:** Java Web Application Development  
**Lab:** Live Lab Test #2

## Description
A Java Servlet/JSP mathematical game with four questions: prime number, modulus, sine and cosine. The application calculates answers using reusable Java methods, checks player answers, saves scores with JDBC/MySQL, and displays the top 10 leaderboard.

## Technologies
- Java 17
- Jakarta Servlet 6 / JSP
- Apache Tomcat 10.1
- Maven
- MySQL 8
- JDBC, HTML, CSS

## Requirements
Install JDK 17, IntelliJ IDEA Ultimate, Apache Tomcat 10.1, Maven (or IntelliJ's bundled Maven), and MySQL Server with MySQL Workbench.

## Database setup
1. Open MySQL Workbench.
2. Open and execute `database/math_whiz_db.sql`.
3. Open `src/main/java/com/suma/mathwhiz/dao/DBConnection.java`.
4. Replace `YOUR_MYSQL_PASSWORD` with your local MySQL root password. Never commit a real password to a public repository.

## Run in IntelliJ
1. Open this folder as a Maven project.
2. Wait for Maven dependencies to download.
3. Set Project SDK to JDK 17.
4. Add a Tomcat 10.1 local server in Run > Edit Configurations.
5. Add the `MathWhiz:war exploded` artifact to deployment.
6. Set application context to `/MathWhiz`.
7. Start Tomcat and open `http://localhost:8080/MathWhiz/`.

## Game rules
- Q1 Prime: enter 1 if prime, otherwise 0 (2 marks).
- Q2 Modulus: enter the integer remainder (2 marks).
- Q3 Sine (3 marks).
- Q4 Cosine (3 marks).
- Difficulty is NORMAL.
- Decimal answers are checked with a tolerance of 0.01.
- Leaderboard sorts by score descending, then played_at ascending, and shows 10 records.

## Project structure
```text
MathWhiz/
├── src/main/java/com/suma/mathwhiz/
│   ├── controller/GameServlet.java
│   ├── dao/DBConnection.java
│   ├── dao/ScoreDAO.java
│   ├── model/GameQuestion.java
│   ├── model/GameResult.java
│   └── service/MathService.java
├── src/main/webapp/
│   ├── WEB-INF/web.xml
│   ├── css/style.css
│   ├── index.jsp
│   ├── game.jsp
│   ├── result.jsp
│   └── leaderboard.jsp
├── database/math_whiz_db.sql
└── README.md
```

## Screenshots
Create a `screenshots/` folder and add your own screenshots after running the application:
- `home.png`
- `game.png`
- `result.png`
- `leaderboard.png`

## Submission
Push the complete project to GitHub and submit the project folder URL, for example:
`https://github.com/your-username/your-repository/tree/main/MathWhiz`
