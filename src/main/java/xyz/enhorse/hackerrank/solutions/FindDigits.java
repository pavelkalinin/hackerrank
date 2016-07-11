package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 17.10.2014.
 */
public class FindDigits {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 15;
    private static final int MIN_NUMBER = 1;
    private static final long MAX_NUMBER = (long)10E10 - 1;

    private static final Scanner STDIN = new Scanner(System.in);


    public static void main(String[] args) {
        solve();
    }
    
    
    private static void solve() {
        int quantityTests = (int) getValidInput(MIN_TESTS, MAX_TESTS);
        long[] numbers = getNumbers(quantityTests);

        for (long number : numbers) {
            int[] digits = getDigits(number);
            int quantityOfDividers = 0;
            for (int digit : digits) {
                if ((digit != 0) && (number % digit) == 0) {
                    quantityOfDividers++;
                }
            }
            System.out.println(quantityOfDividers);
        }
    }


    private static int[] getDigits(long number) {
        char[] digitsAsChar = String.valueOf(number).toCharArray();
        int[] digits = new int[digitsAsChar.length];

        for (int i = 0; i < digitsAsChar.length; i++) {
            digits[i] = Character.getNumericValue(digitsAsChar[i]);
        }

        return digits;
    }

    
    private static long[] getNumbers(int quantityTests) {
        long[] numbers = new long[quantityTests];

        for (int test = 0; test < quantityTests; test++) {
            numbers[test] = getValidInput(MIN_NUMBER, MAX_NUMBER); 
        }
        
        return numbers;
    }
    
    
    private static long getValidInput(long min, long max) {
        long input = 0;

        do {
            try {
                input = STDIN.nextLong();
            } catch (InputMismatchException e) {
                STDIN.next();
            }
        } while ((input < min) || (input > max));

        return input;
    }
}
