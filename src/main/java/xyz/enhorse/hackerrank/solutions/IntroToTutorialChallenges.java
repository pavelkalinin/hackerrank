package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 19.12.2014.
 */
public class IntroToTutorialChallenges {
    private static final int MIN_ARRAY_SIZE = 1;
    private static final int MAX_ARRAY_SIZE = 1000;
    private static final int MIN_NUMBER = -1000;
    private static final int MAX_NUMBER = 1000;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int value = getNumber(MIN_NUMBER, MAX_NUMBER);
        int size = getNumber(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
        int[] array = getArray(size, MIN_NUMBER, MAX_NUMBER);

        System.out.println(findIndex(value, array));
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


    private static int findIndex(int value, int[] array) {
        int result = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                result = i;
                break;
            }
        }

        return result;
    }

}
