package xyz.enhorse.hackerrank.solutions;

import java.util.*;

/**
 * Created by PAK on 07.10.2014.
 */
public class ManasaAndStones {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_STONES = 1;
    private static final int MAX_STONES = (int) 10E3;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTests = getValidInput(sc, MIN_TESTS, MAX_TESTS);
        int[][] sums = new int[numberOfTests][0];

        for (int test = 0; test < numberOfTests; test++) {
            int n = getValidInput(sc, MIN_STONES, MAX_STONES);
            int a = getValidInput(sc, MIN_STONES, MAX_STONES);
            int b = getValidInput(sc, MIN_STONES, MAX_STONES);

            for (int i = 0; i < n; i++) {
                sums[test] = addSum(sums[test], a * (n - i - 1) + b * i);
            }
        }

        for (int i = 0; i < numberOfTests; i++) {
            printArrayInLine(sums[i]);
        }
    }

    public static int[] addSum(int[] sums, int value) {
        boolean isPresent = false;

        if (sums.length > 0) {
            int current = 0;
            while (current < sums.length) {
                if (value == sums[current]) {
                    isPresent = true;
                }
                current++;
            }
        }

        if (!isPresent) {
            int[] result = new int[sums.length + 1];
            for (int i = 0; i < sums.length; i++) {
                result[i] = sums[i];
            }
            result[sums.length] = value;
            Arrays.sort(result);
            return result;
        } else {
            return sums;
        }
    }



    private static void printArrayInLine (int[] array) {
        for (int value : array) {
            System.out.printf("%d ", value);
        }
        System.out.printf("\n");
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
