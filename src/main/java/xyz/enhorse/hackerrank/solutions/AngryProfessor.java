package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/angry-professor
 * 15.01.2016
 */
public class AngryProfessor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int numberOfTests = in.nextInt();
        for (int test = 0; test < numberOfTests; test++) {
            int numberOfStudents = in.nextInt();
            int minQuantityOfStudents = in.nextInt();
            int studentsOnTime = 0;
            for (int student = 0; student < numberOfStudents; student++) {
                if (in.nextInt() <= 0) {
                    studentsOnTime++;
                }
            }
            result.append((minQuantityOfStudents <= studentsOnTime) ? "NO" : "YES").append("\n");
        }
        trimNewLineSymbol(result);
        System.out.println(result);
    }

    private static void trimNewLineSymbol(StringBuilder input) {
        if (input.length() > 0) {
            input.setLength(input.length() - 1);
        }
    }
}
