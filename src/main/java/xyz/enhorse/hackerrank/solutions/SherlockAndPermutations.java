package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 29.12.2014.
 */
public class SherlockAndPermutations {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 200;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;
    private static final long MODULO = (int)1E9 + 7;
    private static final Scanner scanner = new Scanner(System.in);

    private static long[][] combinations = new long[2 * MAX_QUANTITY][MAX_QUANTITY + 1];

    public static void main(String[] args) {
        int numberOfTests = getNumber(MIN_TESTS, MAX_TESTS);
        int[][] tests = new int[numberOfTests][2];

        for (int i = 0; i < numberOfTests; i++) {
            tests[i] = getArray(2, MIN_QUANTITY, MAX_QUANTITY);
        }

        for(int i = 1; i < (MAX_QUANTITY + 1); i++) {
            for(int j = i; j < (2 * MAX_QUANTITY); j++) {
                combinations[j][i] = calc(j, i);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfTests; i++) {
            int n = tests[i][0];
            int m = tests[i][1];
            result.append(combinations[n + m - 1][n] + "\n");
        }
        System.out.printf("%s", result);
    }


    public static long calc(int n, int m) {
        long result = n;

        if (m != 1) {
            result = (combinations[n - 1][m] + combinations[n - 1][m - 1]) % MODULO;
        }

        return result;
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
