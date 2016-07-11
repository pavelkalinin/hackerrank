package xyz.enhorse.hackerrank.solutions;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by PAK on 06.10.2014.
 */
public class AngryChildren {
    private static final int MIN_POCKETS = 1;
    private static final int MAX_POCKETS = (int) 10E5;
    private static final int MIN_KIDS = 1;
    private static final int MIN_CANDIES = 0;
    private static final int MAX_CANDIES = (int) 10E9;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfPockets = getValidInput(sc, MIN_POCKETS, MAX_POCKETS);
        int numberOfKids = getValidInput(sc, MIN_KIDS, numberOfPockets);
        int[] pockets = new int[numberOfPockets];

        for (int i = 0; i < numberOfPockets; i++) {
            pockets[i] = getValidInput(sc, MIN_CANDIES, MAX_CANDIES);
        }

        Arrays.sort(pockets);
        int result = pockets[numberOfKids - 1] - pockets[0];
        for (int i = 1; i <= numberOfPockets - numberOfKids; i++) {
            result = result > pockets[numberOfKids - 1 + i] - pockets[i] ? pockets[numberOfKids - 1 + i] - pockets[i] : result;
        }

        System.out.printf("%d\n", result);
    }




    private static int getValidInput(Scanner sc, int min, int max) {
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
