package xyz.enhorse.hackerrank.solutions;

import java.util.*;

/**
 * Created by PAK on 24.12.2014.
 */
public class MinimumDraws {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 1000;
    private static final int MIN_PAIRS = 0;
    private static final int MAX_PAIRS = (int)1E6;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = getNumber(MIN_TESTS, MAX_TESTS);
        int[] tests = getArray(numberOfTests, MIN_PAIRS, MAX_PAIRS);

        StringBuilder result = new StringBuilder();
        for (int number : tests) {
            result.append(calculateDraw(number) + "\n");
        }
        System.out.printf("%s", result);
    }


    public static long calculateDraw(int n) {
        return n + 1;
    }


    private static int[] getArray(int length, int min, int max) {
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = getNumber(min, max);
        }

        return result;
    }


    private static int getNumber(int min, int max) {
        int result = 0;

        do {
            try {
                result = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.next();
            }
        } while ((result < min) || (result > max));

        return result;
    }

}
