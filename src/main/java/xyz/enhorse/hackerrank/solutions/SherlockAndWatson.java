package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 19.12.2014.
 */
public class SherlockAndWatson {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int) 10E5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = (int) 10E5;
    private static final int MIN_ROTATIONS = 1;
    private static final int MAX_ROTATIONS = (int) 10E5;
    private static final int MIN_QUERIES = 1;
    private static final int MAX_QUERIES = 500;
    private static final int MIN_INDEX = MIN_LENGTH - 1;
    private static final int MAX_INDEX = MAX_LENGTH - 1;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int length = getNumber(MIN_LENGTH, MAX_LENGTH);
        int numberOfRotations = getNumber(MIN_ROTATIONS, MAX_ROTATIONS);
        int numberOfQueries = getNumber(MIN_QUERIES, MAX_QUERIES);
        int[] array = getArray(length, MIN_NUMBER, MAX_NUMBER);
        int[] results = getArray(numberOfQueries, MIN_INDEX, MAX_INDEX);

        solve(numberOfRotations, array, results);

        printArrayInColumn(results);
    }


    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    private static  void leftRotate(int array[], int distance)
    {
        int length = array.length;
        distance = distance > length ? distance % length : distance;
        int gcd = GCD(distance, length);

        for (int offset = 0; offset < gcd; offset++)
        {
            int temp = array[offset];
            int index = offset;
            while(true)
            {
                int tmp = index + distance;
                if (tmp >= length) {
                    tmp = tmp - length;
                }
                if (tmp == offset) {
                    break;
                }
                array[index] = array[tmp];
                index = tmp;
            }
            array[index] = temp;
        }
    }

    private static  void rightRotate(int array[], int distance)
    {
        int length = array.length;
        distance = distance > length ? distance % length : distance;
        int gcd = GCD(distance, length);

        for (int offset = 0; offset < gcd; offset++)
        {
            int temp = array[offset];
            int index = offset;
            while(true)
            {
                int tmp = index - distance;
                if (tmp < 0) {
                    tmp = tmp + length;
                }
                if (tmp == offset) {
                    break;
                }
                array[index] = array[tmp];
                index = tmp;
            }
            array[index] = temp;
        }
    }


    private static void solve(int numberOfRotations, int[] array, int[] results) {
        rightRotate(array, numberOfRotations);
        for (int i = 0; i < results.length; i++) {
            results[i] = array[results[i]];
        }
    }


    private static void printArrayInColumn(int[] array) {
        for (int result : array) {
            System.out.println(result);
        }
    }


    private static void printArrayInRow(int[] array) {
        for (int result : array) {
            System.out.printf("%d ", result);
        }
        System.out.printf("\n");
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
