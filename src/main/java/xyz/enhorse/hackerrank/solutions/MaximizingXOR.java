package xyz.enhorse.hackerrank.solutions;

/**
 * Created by enhorse on 05.10.14.
 */

import java.util.*;

public class MaximizingXOR {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = (int) 10E3;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l, r;

        do {
            l = getValidInput(sc, MIN_VALUE, MAX_VALUE);
            r = getValidInput(sc, MIN_VALUE, MAX_VALUE);
        } while (l > r);

        System.out.printf("%d\n", getMaxXOR(l, r));

    }



    private static int getMaxXOR(int l, int r) {
        int result = 0;

        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                result = Math.max(result, j^i);
            }
        }

        return result;
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
