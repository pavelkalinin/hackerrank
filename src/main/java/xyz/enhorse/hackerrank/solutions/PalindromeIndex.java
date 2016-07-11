package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 16.12.2014.
 */
public class PalindromeIndex {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 20;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 200005;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = getNumberOfTests(MIN_TESTS, MAX_TESTS);
        int[] results = new int[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            String string = getString(MIN_LENGTH, MAX_LENGTH);
            int result = -1;

            for (int start = 0, end = string.length() - 1; start < end; start++, end--) {
                if (string.charAt(start) != string.charAt(end)) {
                    if (isPalindrome(string.substring(0, start) + string.substring(start + 1))) {
                        result = start;
                        break;
                    }
                    result = end;
                    break;
                }
            }
            results[i] = result;
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static boolean isPalindrome(String s) {
        boolean result = true;
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static String getString(int min, int max) {
        String result;

        do {
            result = sc.nextLine();
        } while ((result.length() < min) || (result.length() > max));

        return result;
    }


    private static int getNumberOfTests(int min, int max) {
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
