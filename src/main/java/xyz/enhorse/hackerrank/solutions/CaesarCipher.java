package xyz.enhorse.hackerrank.solutions;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 *         15.01.2016
 */
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] original = in.next().toCharArray();
        int k = in.nextInt();
        StringBuilder encrypted = new StringBuilder(n);
        for (char c : original) {
            char current = c;

            if (Character.isLetter(c)) {
                int base = (Character.isUpperCase(c))
                        ? (0x41)
                        : (0x61);

                current = (char) ((current - base + k) % 26 + base);
            }
            encrypted.append(current);
        }
        System.out.println(encrypted);
    }
}
