package xyz.enhorse.hackerrank.solutions;

/**
 * Created by enhorse on 04.10.14.
 */
import java.util.*;

public class ServiceLane {
    private static final int MIN_TESTS = 1;
    private static final int MAX_TESTS = 1000;
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 100000;
    private static final int MIN_WIDTH = 1;
    private static final int MAX_WIDTH = 3;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int laneLength;
        int numberOfTests;
        boolean isValid;

        do {
            int[] input = getValidInput(sc, 2);
            laneLength = input[0];
            numberOfTests = input[1];
        } while ((laneLength < MIN_LENGTH) || (laneLength > MAX_LENGTH) || (numberOfTests < MIN_TESTS) || (numberOfTests > MAX_TESTS));

        int[] widthOfLane;
        do {
            widthOfLane = getValidInput(sc, laneLength);
            isValid = true;
            for (int width : widthOfLane) {
                if ((width < MIN_WIDTH) || (width > MAX_WIDTH)) {
                    isValid = false;
                    break;
                }
            }
        } while (!isValid);

        int[][] tests = new int[numberOfTests][2];
        for (int i = 0; i < numberOfTests; i++) {
            do {
                tests[i] = getValidInput(sc, 2);
                isValid = (0 <= tests[i][0]) && (tests[i][0] < tests[i][1]) && (tests[i][1] < laneLength);
            } while (!isValid);
        }

        for (int i = 0; i < numberOfTests; i++) {
            int vehicle = 3;
            for (int currentWidth = tests[i][0]; currentWidth <= tests[i][1]; currentWidth++) {
                vehicle = Math.min(widthOfLane[currentWidth], vehicle);
                if (vehicle == 1) {
                    break;
                }
            }
            System.out.printf("%d\n", vehicle);
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