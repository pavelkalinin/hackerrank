package xyz.enhorse.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PAK on 17.10.2014.
 */
public class IsFibo {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = (int)10E5;
    private static final int MIN_NUMBER = 1;
    private static final long MAX_NUMBER = (long)10E10;

    private static final String IS_FIBO = "IsFibo";
    private static final String IS_NOT_FIBO = "IsNotFibo";

    private static double GOLDEN_SECTION_POSITIVE = ((1 + Math.sqrt(5)) / 2);
    private static double GOLDEN_SECTION_NEGATIVE = ((1 - Math.sqrt(5)) / 2);

    private static final Scanner STDIN = new Scanner(System.in);


    public static void main(String[] args) {
        solve();
    }


    private static void solve() {
        int quantityOfTest = getQuantityOfTest();
        long[] numbers = getNumbers(quantityOfTest);
        long maxNumber = maxValue(numbers);
        int requiredQuantityOfFibos = getQuantityOfFiboNumbers(maxNumber);
        long[] fiboNumbers = getFibos(requiredQuantityOfFibos);

        for (long number : numbers) {
            System.out.println(Arrays.binarySearch(fiboNumbers, number) > 0 ? IS_FIBO : IS_NOT_FIBO);
        }
    }


    private static int getQuantityOfTest() {
        int quantityOfTest;

        do {
            quantityOfTest = (int) getInput(1)[0];
        } while ((quantityOfTest < MIN_TESTS) || (quantityOfTest > MAX_TESTS));

        return quantityOfTest;
    }


    private static long[] getNumbers(int quantity) {
        long[] numbers = new long[quantity];

        for (int i = 0; i < quantity; i++) {
            do {
                numbers[i] = getInput(1)[0];
            } while ((numbers[i] < MIN_NUMBER) || (numbers[i]) > MAX_NUMBER);
        }
        return numbers;
    }


    private static long[] getFibos(int quantity) {
        long[] fiboNumbers = new long[quantity];

        for (int i = 0; i < fiboNumbers.length; i++) {
            fiboNumbers[i] = getFiboNumberByBine(i);
        }

        return fiboNumbers;
    }


    public static long maxValue(long[] array) {
        long maxValue = Long.MIN_VALUE;

        if (array != null) {
            for (long value : array) {
                maxValue = value >= maxValue ? value : maxValue;
            }
        }

        return maxValue;
    }


    private static int getQuantityOfFiboNumbers (long maxNumber) {
        long fibo = 0;
        int quantity = 0;

        while (fibo <= maxNumber) {
            quantity++;
            fibo = getFiboNumberByBine(quantity);
        }

        return quantity;
    }


    private static long getFiboNumberByBine(int n) {
        return  (long)((Math.pow(GOLDEN_SECTION_POSITIVE, n) - Math.pow(GOLDEN_SECTION_NEGATIVE, n)) / Math.sqrt(5));
    }


    private static long[] getInput(int length) {
        long[] input = new long[length];
        boolean isValidInput = false;

        do {
            String[] inputWords = STDIN.nextLine().split("\\s+");

            if (inputWords.length == length) {
                try {
                    for (int i = 0; i < inputWords.length; i++) {
                        input[i] = Long.parseLong(inputWords[i]);
                    }
                    isValidInput = true;
                }
                catch (NumberFormatException nfe) {
                    STDIN.next();
                }
            }
        } while (!isValidInput);

        return input;
    }
}
