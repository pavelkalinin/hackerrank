package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by PAK on 16.10.2014.
 */
public class FillingJars {
    private static final int QUANTITY_OF_BASE_PARAMETERS = 2;
    private static final int INDEX_OF_QUANTITY_OF_JARS = 0;
    private static final int INDEX_OF_QUANTITY_OF_OPERATIONS = 1;

    private static final int QUANTITY_OF_OPERATION_PARAMETERS = 3;
    private static final int INDEX_OF_JAR_FROM = 0;
    private static final int INDEX_OF_JAR_TO = 1;
    private static final int INDEX_OF_QUANTITY_OF_CANDIES = 2;

    private static final int MIN_JARS = 3;
    private static final int MAX_JARS = (int)10E7;
    private static final int MIN_OPERATIONS = 1;
    private static final int MAX_OPERATIONS = (int)10E5;
    private static final int MIN_CANDIES = 0;
    private static final int MAX_CANDIES = (int)10E6;
    private static final int FIRST_JAR = 1;

    private static final Scanner STDIN = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println(solve());
    }


    private static long solve() {
        long averageOfCandies;
        int[] baseParameters = getBaseParameters();

        int quantityOfJars = baseParameters[INDEX_OF_QUANTITY_OF_JARS];
        int quantityOfOperations = baseParameters[INDEX_OF_QUANTITY_OF_OPERATIONS];
        averageOfCandies = getSumOfCandies(quantityOfJars, quantityOfOperations) / quantityOfJars;

        return averageOfCandies;
    }


    private static int[] getBaseParameters() {
        int[] baseParameters;
        boolean isValidInput;

        do {
            isValidInput = true;

            baseParameters = getInput(QUANTITY_OF_BASE_PARAMETERS);

            int quantityOfJars = baseParameters[INDEX_OF_QUANTITY_OF_JARS];
            int quantityOfOperations = baseParameters[INDEX_OF_QUANTITY_OF_OPERATIONS];

            if ((quantityOfJars > MAX_JARS) || (quantityOfJars < MIN_JARS)
                    || (quantityOfOperations < MIN_OPERATIONS) || (quantityOfOperations > MAX_OPERATIONS)) {
                isValidInput = false;
            }
        } while (!isValidInput);

        return baseParameters;
    }


    private static long getSumOfCandies(int quantityOfJars, int quantityOfOperations) {
        long sumOfCandies = 0;
        boolean isValidInput;

        for (int i = 0; i < quantityOfOperations; i++) {
            long candiesAdded = 0;

            do {
                isValidInput = true;

                int[] operation = getInput(QUANTITY_OF_OPERATION_PARAMETERS);
                int jarFrom = operation[INDEX_OF_JAR_FROM];
                int jarTo = operation[INDEX_OF_JAR_TO];
                int quantityCandies = operation[INDEX_OF_QUANTITY_OF_CANDIES];

                if ((jarFrom < FIRST_JAR) || (jarFrom > jarTo)
                        || (jarTo < FIRST_JAR) || (jarTo > quantityOfJars)
                        || (quantityCandies < MIN_CANDIES) || (quantityCandies > MAX_CANDIES)) {
                    isValidInput = false;
                }
                else {
                    candiesAdded = (long) quantityCandies * (jarTo - jarFrom + 1);
                }
            } while (!isValidInput);
            sumOfCandies += candiesAdded;
        }

        return sumOfCandies;
    }


    private static int[] getInput(int length) {
        int[] input = new int[length];
        boolean isValidInput = false;

        do {
            String[] inputWords = STDIN.nextLine().split("\\s+");

            if (inputWords.length == length) {
                try {
                    for (int i = 0; i < inputWords.length; i++) {
                        input[i] = Integer.parseInt(inputWords[i]);
                    }
                    isValidInput = true;
                }
                catch (NumberFormatException nfe) {
                    STDIN.next();
                }
            }
        } while (!isValidInput);

        return input;
    }
}
