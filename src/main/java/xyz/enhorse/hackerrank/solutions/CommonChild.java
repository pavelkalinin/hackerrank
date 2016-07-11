package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by PAK on 17.12.2014.
 */
public class CommonChild {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5000;
    private static final Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        String father, mother;
        do {
            father = getValidWord();
            mother = getValidWord();
        } while (father.length() != mother.length());
        System.out.println(getCommonChild(father, mother));
    }


    private static String getValidWord() {
        String result;
        do {
            result = sc.nextLine();
        } while ((result.length() < MIN_LENGTH) || (result.length() > MAX_LENGTH) || !isValidInput(result));
        return result;
    }


    private static boolean isValidInput(String s) {
        boolean result = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
                result = false;
                break;
            }
        }

        return result;
    }


    private static void printArray(int[][] array, char c) {
        System.out.printf("%c", c);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("=");
        }
        System.out.printf("\n");

        for (int i = 0; i < array.length; i++) {
            for (int value : array[i]) {
                System.out.printf("%d", value);
            }
            System.out.printf("\n");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("=");
        }
        System.out.printf("\n\n");
    }


    private static int getCommonChild (String father, String mother) {
        int length = father.length();
        int[][] array = new int[length+1][length+1];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if (father.charAt(i) == mother.charAt(j)) {
                    array[i+1][j+1] = array[i][j] + 1;
                }
                else {
                    array[i+1][j+1] = Math.max(array[i][j+1], array[i+1][j]);
                }
            }
            printArray(array, father.charAt(i));
        }

        return array[length][length];
    }

}

