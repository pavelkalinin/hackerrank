package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 13.10.2014.
 */
public class ChocolateFeast {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 1000;
    private static final int MIN_MONEY = 2;
    private static final int MAX_MONEY = 100000;
    private static final int MIN_PRICE = 1;
    private static final int MIN_WRAPPERS = 2;
    private static final int INPUT_LENGTH = 3;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = getValidInput(sc, MIN_TESTS, MAX_TESTS);

        int[][] tests = new int [numberOfTests][INPUT_LENGTH];

        for (int i = 0; i < numberOfTests; i++) {
            do {
                tests[i] = getValidInput(sc, INPUT_LENGTH);
            } while ((tests[i][0] < MIN_MONEY) || (tests[i][0] > MAX_MONEY) ||
                    (tests[i][1] < MIN_PRICE) || (tests[i][1] > tests[i][0]) ||
                    (tests[i][2] < MIN_WRAPPERS) || (tests[i][2] > tests[i][0]));
        }

        for (int i = 0; i < numberOfTests; i++) {
            int money = tests[i][0];
            int price = tests[i][1];
            int wrapper = tests[i][2];
            int choco = money / price;
            int wrappers = choco;
            while (wrappers / wrapper > 0) {
                int temp = wrappers / wrapper;
                choco += temp;
                wrappers = wrappers - (wrapper * temp) + temp;
            }
            System.out.println(choco);
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



    private static int[] getValidInput(Scanner sc, int length) {
        int[] result = new int[length];
        boolean isValid = false;
        String[] input;

        do {
            input = sc.nextLine().split("\\s+");
            if (input.length == length) {
                try {
                    for (int i = 0; i < input.length; i++) {
                        result[i] = Integer.parseInt(input[i]);
                    }
                    isValid = true;
                }
                catch (NumberFormatException nfe) {
                    sc.next();
                }
            }
        } while (!isValid);

        return result;
    }
}
