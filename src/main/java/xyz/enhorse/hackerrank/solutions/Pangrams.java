package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by PAK on 16.12.2014.
 */
public class Pangrams {
    private static String TRUE = "pangram";
    private static String FALSE = "not pangram";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;
    private static final int FIRST_LETTER = 'A';
    private static final int LAST_LETTER = 'Z';
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String string = getValidInput(MIN_LENGTH, MAX_LENGTH);
        boolean panagram = true;

        for (int i = FIRST_LETTER; i <= LAST_LETTER; i++) {
            if (string.indexOf(i) < 0) {
                panagram = false;
                break;
            }
        }
        System.out.println(panagram ? TRUE:FALSE);
    }


    private static String getValidInput(int min, int max) {
        String result;

        do {
            result = sc.nextLine();
        } while ((result.length() < min) || (result.length() > max));

        return result.toUpperCase();
    }

}
