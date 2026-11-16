package com.suma.mathwhiz.model;

public class GameQuestion {
    private final String prompt;
    private final String type;
    private final double expectedAnswer;
    private final int marks;
    private final boolean integerAnswer;

    public GameQuestion(String prompt, String type, double expectedAnswer, int marks, boolean integerAnswer) {
        this.prompt = prompt;
        this.type = type;
        this.expectedAnswer = expectedAnswer;
        this.marks = marks;
        this.integerAnswer = integerAnswer;
    }
    public String getPrompt() { return prompt; }
    public String getType() { return type; }
    public double getExpectedAnswer() { return expectedAnswer; }
    public int getMarks() { return marks; }
    public boolean isIntegerAnswer() { return integerAnswer; }
}
