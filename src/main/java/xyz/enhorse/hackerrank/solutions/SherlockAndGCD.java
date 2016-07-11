package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by PAK on 06.10.2014.
 */
public class SherlockAndGCD {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 100;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = (int) 10E5;
    private static final String YES = "YES";
    private static final String NO = "NO";



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests;
        int quantityOfNumbers;

        do {
            numberOfTests = getValidInput(sc, 1)[0];
        } while ((numberOfTests < MIN_TESTS) || (numberOfTests > MAX_TESTS));

        int[][] numbers = new int[numberOfTests][];
        for (int i = 0; i < numberOfTests; i++) {
            do {
                quantityOfNumbers = getValidInput(sc, 1)[0];
            } while ((numberOfTests < MIN_QUANTITY) || (numberOfTests > MAX_QUANTITY));

            boolean isValid;
            do {
                isValid = true;
                numbers[i] = getValidInput(sc, quantityOfNumbers);
                for (int number : numbers[i]) {
                    if ((number > MAX_NUMBER) || (number) < MIN_NUMBER ) {
                        isValid = false;
                        break;
                    }
                }
            } while (!isValid);
        }

        int gcd = 0;
        for (int test = 0; test < numberOfTests; test++) {
            for (int i = 0; i < numbers[test].length; i++) {
                for (int j = i + 1; j < numbers[test].length; j++) {
                    gcd = calcGCD(numbers[test][i], numbers[test][j]);
                    if (gcd == 1) {
                        break;
                    }
                }
                if (gcd == 1) {
                    break;
                }
            }
            System.out.printf("%s\n", gcd == 1 ? YES : NO);
        }
    }



    public static int calcGCD(int a, int b) {
        return b == 0 ? a : calcGCD(b, a % b);
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
