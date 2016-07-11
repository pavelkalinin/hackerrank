package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * Created by PAK on 16.12.2014.
 */
public class AcmIcpcTeam {
    private static int INDEX_OF_PEOPLE = 0;
    private static int INDEX_OF_TOPICS = 1;
    private static final int MIN_PEOPLE = 2;
    private static final int MAX_PEOPLE = 500;
    private static final int MIN_TOPICS = 1;
    private static final int MAX_TOPICS = 500;
    private static final char YES = '1';
    private static final char NO = '0';
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfPeople, numberOfTopics;

        do {
            int[] input = getValidInput(2);
            numberOfPeople = input[INDEX_OF_PEOPLE];
            numberOfTopics = input[INDEX_OF_TOPICS];
        } while ((numberOfPeople < MIN_PEOPLE || numberOfPeople > MAX_PEOPLE)
                || (numberOfTopics < MIN_TOPICS || numberOfTopics > MAX_TOPICS));

        int[][] people = new int[numberOfPeople][numberOfTopics];

        for (int i = 0; i < numberOfPeople; i++) {
            people[i] = getSkills(numberOfTopics);
        }

        int maxTopics = 0;
        int maxTeams = 0;

        for (int i = 0; i < numberOfPeople; i++) {
            for (int j = i + 1; j < numberOfPeople; j++) {
                int currentMax = 0;
                for (int k = 0; k < numberOfTopics; k++) {
                    if (people[i][k] == 1 || people[j][k] == 1) {
                        currentMax++;
                    }
                }
                if (currentMax >= maxTopics) {
                    if (currentMax > maxTopics) {
                        maxTopics = currentMax;
                        maxTeams = 0;
                    }
                    maxTeams++;
                }
            }
        }
        System.out.printf("%d\n%d\n", maxTopics, maxTeams);
    }


    private static int[] getValidInput(int length) {
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


    private static boolean isValidBinaryString(String s) {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter != YES && letter !=NO) {
                result = false;
                break;
            }
        }
        return result;
    }


    private static int[] getSkills(int numberOfTopics) {
        String skills;
        int[] result = new int[numberOfTopics];

        do {
            skills = sc.next();
        } while (skills.length() != numberOfTopics || !isValidBinaryString(skills));

        for (int i = 0; i < skills.length(); i++) {
             if (skills.charAt(i) == YES) {
                 result[i] = 1;
             } else {
                 result[i] = 0;
             }
        }

        return result;
    }
}
