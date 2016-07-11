package xyz.enhorse.hackerrank.solutions;

/**
 * Created by enhorse on 04.10.14.
 */
import java.util.*;

public class SherlockAndSquares {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 100;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = (int) 10E9;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests;

        do {
            numberOfTests = getValidInput(sc, 1)[0];
        } while ((numberOfTests < MIN_TESTS) || (numberOfTests > MAX_TESTS));

        int[][] numbers = new int[numberOfTests][2];
        for (int i = 0; i < numberOfTests; i++) {
            do {
                numbers[i] = getValidInput(sc, 2);
            } while ((numbers[i][0] > numbers[i][1]) || (numbers[i][0] < MIN_NUMBER) || (numbers[i][1] > MAX_NUMBER));
        }

        for (int i = 0; i < numberOfTests; i++) {
            int A = (int) (Math.ceil(Math.sqrt(numbers[i][0])));
            int B = (int) (Math.floor(Math.sqrt(numbers[i][1])) + 1);
            System.out.printf("%d\n", B - A);
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
                }
                catch (NumberFormatException nfe) {
                    sc.next();
                }
            }
        } while (!isValid);

        return result;
    }
}
