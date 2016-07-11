package xyz.enhorse.hackerrank.solutions;

/**
 * Created by enhorse on 05.10.14.
 */

import java.util.*;
import java.util.regex.*;

public class TheLoveLetterMystery {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int) 10E4;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = getValidInputInt(sc, MIN_TESTS, MAX_TESTS);

        String[] words = new String[numberOfTests];
        for (int i = 0; i < numberOfTests; i++) {
                words[i] = getValidInputString(sc, MIN_LENGTH, MAX_LENGTH);
        }

        for (int i = 0; i < numberOfTests; i++) {
            int counter = 0;
            for (int j = 0; j < words[i].length() / 2; j++) {
                char from = words[i].charAt(words[i].length() - j - 1);
                char to = words[i].charAt(j);
                counter += countOperations(from, to);
            }
            System.out.printf("%d\n", counter);
        }
    }



    private static int getValidInputInt(Scanner sc, int min, int max) {
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


    private static int countOperations (char from, char to) {
        return Math.abs((int) from - (int) to);
    }
}
