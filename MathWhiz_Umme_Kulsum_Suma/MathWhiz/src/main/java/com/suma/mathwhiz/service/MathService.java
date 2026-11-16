package com.suma.mathwhiz.service;

public class MathService {
    public static int isPrime(int number) {
        if (number < 2) return 0;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return 0;
        }
        return 1;
    }

    public static int calculateMod(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Divisor cannot be zero.");
        return a % b;
    }

    public static double calculateSin(double degree) {
        return Math.sin(Math.toRadians(degree));
    }
    public static double calculateCos(double degree) {
        return Math.cos(Math.toRadians(degree));
    }
    public static double calculateTan(double degree) {
        double normalized = Math.abs(degree % 180.0);
        if (Math.abs(normalized - 90.0) < 1e-10)
            throw new IllegalArgumentException("Tangent is undefined at this angle.");
        return Math.tan(Math.toRadians(degree));
    }

    public static boolean isCorrect(String answer, double expected, boolean integerAnswer) {
        try {
            double actual = Double.parseDouble(answer.trim());
            if (!Double.isFinite(actual)) return false;
            if (integerAnswer) return actual == Math.rint(actual) && (int) actual == (int) expected;
            return Math.abs(actual - expected) <= 0.01;
        } catch (Exception ex) {
            return false;
        }
    }
}
