package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 16.12.2014.
 */
public class AlternatingCharacters {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 10;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int) 10E5;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfTests = getValidInput(MIN_TESTS, MAX_TESTS);
        String[] words = new String[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            do {
                words[i] = sc.next();
            } while ((words[i].length() < MIN_LENGTH) || (words[i].length() > MAX_LENGTH));
        }

        for (String s : words) {
            System.out.println(processWord(s));
        }
    }


    private static int getValidInput(int min, int max) {
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


    private static int processWord(String word) {
        StringBuilder result = new StringBuilder();

        result.append(word.charAt(0));
        for (int i = 1; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter != result.charAt(result.length() - 1)) {
                result.append(letter);
            }
        }
        return word.length()-result.length();
    }
}
