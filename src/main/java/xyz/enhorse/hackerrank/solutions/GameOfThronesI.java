package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PAK on 13.10.2014.
 */
public class GameOfThronesI {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int) 10E5;
    private static final int NUMBER_OF_ENGLISH_LETTERS = 26;
    private static final String NO = "NO";
    private static final String YES = "YES";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = getValidInputString(sc, MIN_LENGTH, MAX_LENGTH).toCharArray();
        int[] quantity = new int[NUMBER_OF_ENGLISH_LETTERS];

        for (int i = 0; i < input.length; i++) {
            int index = input[i] - 'a';
            quantity[index]++;
        }

        int counter = 0;
        for (int i = 0; i < quantity.length; i++) {
            counter += quantity[i] % 2;
        }

        if (counter >= 2) {
            System.out.println(NO);
        } else {
            System.out.println(YES);
        }
    }



    private static String getValidInputString(Scanner sc, int min, int max) {
        String result = "";
        boolean isValidWord = false;

        do {
            try {
                result = sc.nextLine();
                Pattern pattern = Pattern.compile("[a-z]+");
                Matcher matcher = pattern.matcher(result);
                isValidWord = matcher.matches();
            }
            catch (InputMismatchException e) {
                sc.next();
            }
        } while ((!isValidWord) || (result.length() < min) || (result.length() > max));

        return result;
    }
}
