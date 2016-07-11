package xyz.enhorse.hackerrank.solutions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by PAK on 07.10.2014.
 */
public class CutTheSticks {
    private static final int MIN_QUANTITY = 1;
    private static final int MAX_QUANTITY = 1000;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 1000;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantity;

        do {
            quantity = getValidInput(sc, 1)[0];
        } while ((quantity < MIN_QUANTITY) || (quantity > MAX_QUANTITY));

        int[] sticks;
        boolean isValid;
        do {
            isValid = true;
            sticks = getValidInput(sc, quantity);
            for (int stick : sticks) {
                if ((stick > MAX_LENGTH) || (stick < MIN_LENGTH)) {
                    isValid = false;
                    break;
                }
            }
        } while (!isValid);

        Arrays.sort(sticks);
        for (int i = 0; i < quantity; ) {
            int j = i;
            while ((j < quantity) && (sticks[j] == sticks[i])) {
                j++;
            }
            System.out.printf("%d\n", quantity - i);
            i = j;
        }
    }



    private static int[] getValidInput(Scanner sc, int length) {
        int[] result = new int[length];
        boolean isValid = false;
        String[] input;

        do {
            input = sc.nextLine().split("\\s+");
            if (input.length == length) {
                try {
                    for (int i = 0; i < input.length; i++) {
                        result[i] = Integer.parseInt(input[i]);
                    }
                    isValid = true;
                } catch (NumberFormatException nfe) {
                    sc.next();
                }
            }
        } while (!isValid);

        return result;
    }
}
