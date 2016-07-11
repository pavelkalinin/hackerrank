package xyz.enhorse.hackerrank.solutions;

import java.util.*;

/**
 * Created by PAK on 22.12.2014.
 */

public class SherlockAndQueries {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = (int)1E5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = (int)1E5;
    private static final long MODULO = (long)1E9 + 7L;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = getNumber(MIN_LENGTH, MAX_LENGTH);
        int m = getNumber(MIN_LENGTH, MAX_LENGTH);

        List<Long> a = getList(n, MIN_NUMBER, MAX_NUMBER);
        long[] b = getArray(m, MIN_NUMBER, n);
        long[] c = getArray(m, MIN_NUMBER, MAX_NUMBER);

        Map<Long, Long> counts = new HashMap<>();

        for (int i = 0; i < m; i++) {
            if (counts.containsKey(b[i])) {
                counts.put(b[i], (counts.get(b[i]) * c[i]) % MODULO);
            }
            else {
                counts.put(b[i], c[i]);
            }
        }

        for (Long i = 1L; i < n + 1; i++) {
            for (Long j = 1L; j < (n / i) + 1L; j++) {
                if (counts.containsKey(i)) {
                    a.set((int)(i * j), (a.get((int)(i * j)) * counts.get(i)) % MODULO);
                }
            }
        }

        StringBuilder result = new StringBuilder(a.get(1).toString());
        for (int i = 2; i < a.size(); i++) {
            result.append(" " + a.get(i));
        }

        System.out.println(result);
    }


    private static List<Long> getList(int length, long min, long max) {
        List<Long> result = new ArrayList<>();
        result.add(0L);

        for (int i = 0; i < length; i++) {
            result.add(new Long(getNumber(min, max)));
        }
        return result;
    }


    private static long[] getArray(int length, long min, long max) {
        long[] result = new long[length];

        for (int i = 0; i < length; i++) {
            result[i] = getNumber(min, max);
        }

        return result;
    }


    private static int getNumber(long min, long max) {
        int result = 0;

        do {
            try {
                result = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                scanner.next();
            }
        } while ((result < min) || (result > max));

        return result;
    }

}
