package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 13.10.2014.
 */
public class HalloweenParty {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final long MIN_CUT_TIMES = 2;
    private static final long MAX_CUT_TIMES = (int) 10E7;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long numberOfTests = getValidInput(sc, MIN_TESTS, MAX_TESTS);
        long[] sums = new long[(int) numberOfTests];

        for (int test = 0; test < numberOfTests; test++) {
            long n = getValidInput(sc, MIN_CUT_TIMES, MAX_CUT_TIMES);
            sums[test] = (n / 2) * (n - (n / 2));
        }

        printArray(sums);
    }



    private static void printArray (long[] array) {
        for (long value : array) {
            System.out.println(value);
        }
    }



    private static long getValidInput(Scanner sc, long min, long max) {
        long result = 0;

        do {
            try {
                result = sc.nextLong();
            } catch (InputMismatchException e) {
                sc.next();
            }
        } while ((result < min) || (result > max));

        return result;
    }
}
