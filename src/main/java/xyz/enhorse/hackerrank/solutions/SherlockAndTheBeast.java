package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by enhorse on 12.10.14.
 */
public class SherlockAndTheBeast {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 20;
    private static final int MIN_DIGITS = 1;
    private static final int MAX_DIGITS = 100000;
    private static final char THREE = '3';
    private static final char FIVE = '5';


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTests = getValidInput(sc, MIN_TESTS, MAX_TESTS);
        int[] digits = new int[numberOfTests];

        for (int test = 0; test < numberOfTests; test++) {
            digits[test] = getValidInput(sc, MIN_DIGITS, MAX_DIGITS);
        }

        for (int test = 0; test < numberOfTests; test++) {
            int number = 5 * (2 * digits[test] % 3);
            if (number > digits[test]) {
                System.out.printf("%d\n", -1);
            } else {
                printNTimes(FIVE, digits[test] - number);
                printNTimes(THREE, number);
                System.out.printf("\n");
            }
        }
    }


    private static void printNTimes(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }
        System.out.printf("%s", sb.toString());
    }


    private static int getValidInput(Scanner sc, int min, int max) {
        int result = 0;

        do {
            try {
                result = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }
        } while ((result < min) || (result > max));

        return result;
    }
}

