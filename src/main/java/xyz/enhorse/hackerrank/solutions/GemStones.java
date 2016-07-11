package xyz.enhorse.hackerrank.solutions;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PAK on 13.10.2014.
 */
public class GemStones {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 100;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 100;
    private static final int NUMBER_OF_ENGLISH_LETTERS = 26;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantity = getValidInputInt(sc, MIN_QUANTITY, MAX_QUANTITY);

        String[] stones = new String[quantity];
        for (int i = 0; i < quantity; i++) {
            stones[i] = getValidInputString(sc, MIN_LENGTH, MAX_LENGTH);
        }

        int result = 0;
        for (int i = 0; i < NUMBER_OF_ENGLISH_LETTERS; i++) {
            char letter = (char) ('a' + i);
            boolean isPresent = true;
            for (String stone : stones) {
                if (!stone.contains(letter + "")) {
                    isPresent =false;
                    break;
                };
            }
            if (isPresent) {
                result++;
            }
        }

        System.out.println(result);
    }



    private static int getValidInputInt(Scanner sc, int min, int max) {
        int result = 0;

        do {
            try {
                result = sc.nextInt();
            } catch (InputMismatchException e) {
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
}
