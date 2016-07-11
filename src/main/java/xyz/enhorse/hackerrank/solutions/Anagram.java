package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 17.12.2014.
 */
public class Anagram {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 100;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 10000;
    private static final int IMPOSSIBLE = -1;
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int numberOfTests = getNumberOfTests(MIN_TESTS, MAX_TESTS);
        String[] words = new String[numberOfTests];

        for (int i = 0; i < numberOfTests; i++) {
            do {
                words[i] = sc.next();
            } while ((words[i].length() < MIN_LENGTH) || (words[i].length() > MAX_LENGTH) || !isValidInput(words[i]));
        }

        for (String s : words) {
            System.out.println(processWord(s));
        }
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


    private static boolean isValidInput(String input) {
        return (input.toLowerCase().equals(input) && input.indexOf(" ") < 0);
    }


    private static int processWord(String word) {
        if (word.length() % 2 != 0) {
            return IMPOSSIBLE;
        }

        StringBuilder a = new StringBuilder(word);
        a.delete(word.length() / 2, word.length());
        StringBuilder b = new StringBuilder(word);
        b.delete(0, word.length() / 2);

        int result = 0;
        for (int i = 0; i < b.length(); i++) {
            int index = a.indexOf(b.substring(i, i + 1));
            if (index < 0) {
                result++;
            } else {
                a.delete(index, index + 1);
            }
        }

        return result;
    }
}
