package xyz.enhorse.hackerrank.solutions;

/**
 * Created by enhorse on 04.10.14.
 */

import java.util.*;

public class UtopianTree {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_CYCLES = 0;
    private static final int MAX_CYCLES = 60;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfTests = getValidInput(sc, MIN_TESTS, MAX_TESTS);
        int[] cycles = new int[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            cycles[i] = getValidInput(sc, MIN_CYCLES, MAX_CYCLES);
        }

        for (int current : cycles) {
            int treeHeight = 1;

            for (int i = 1; i <= current; i++) {
                if (i % 2 == 0)  {
                    treeHeight++;
                } else {
                    treeHeight *= 2;
                }
            }

            System.out.println(treeHeight);
        }
    }

    private static int getValidInput(Scanner sc, int min, int max) {
        int result = 0;

        do {
            try {
                result = sc.nextInt();
            }
            catch (InputMismatchException e) {
                sc.next();
            }
        } while ((result < min) || (result > max));

        return result;
    }
}
