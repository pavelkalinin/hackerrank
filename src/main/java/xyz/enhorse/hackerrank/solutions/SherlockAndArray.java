package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 19.12.2014.
 */
public class SherlockAndArray {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int) 10E5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 2 * (int) 10E4;
    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = getNumber(MIN_TESTS, MAX_TESTS);
        boolean[] results = new boolean[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            int length = getNumber(MIN_LENGTH, MAX_LENGTH);
            int[] array = getArray(length, MIN_NUMBER, MAX_NUMBER);
            results[i] = isPresent(array);
        }

        for (boolean result : results) {
            System.out.println(result ? YES : NO);
        }
    }


    private static int getSum(int[] array) {
        int result = 0;

        for (int number : array) {
            result += number;
        }

        return result;
    }


    private static boolean isPresent(int[] array) {
        boolean result = false;
        int leftSum = 0;
        int rightSum = getSum(array);

        for (int i = 0; i < array.length; i++) {
            leftSum = i == 0 ? 0 : leftSum+array[i - 1];
            rightSum = i == array.length - 1 ? 0 : rightSum - array[i];
            if (leftSum == rightSum) {
                result = true;
                break;
            }
        }

        return result;
    }


    private static int getNumber(int min, int max) {
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


    private static int[] getArray(int length, int min, int max) {
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = getNumber(min, max);
        }

        return result;
    }
}
