package xyz.enhorse.hackerrank.solutions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * https://www.hackerrank.com/challenges/longest-increasing-subsequent
 */
public class TheLongestIncreasingSubsequence {
    private static final FastReader in = new FastReader(System.in);

    public static void main(String[] args) throws IOException {
        int[] sequence = readSequence(in.nextInt());
        System.out.println(longestIncreasingSubsequenceLength(sequence));
    }

    private static int[] readSequence(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = in.nextInt();
        }
        return result;
    }

    private static int longestIncreasingSubsequenceLength(int[] sequence) {
        int n = sequence.length;
        int[] tmp = new int[n];

        int length = 0;
        for (int i = 0; i < n; i++) {
            int pos = lowerBound(sequence, tmp, length, sequence[i]);
            if (pos == length) {
                ++length;
            }
            tmp[pos] = i;
        }

        return length;
    }

    private static int lowerBound(int[] a, int[] tmp, int length, int key) {
        int lo = -1;
        int hi = length;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tmp[mid]] < key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }
}

class FastReader {
    private final int bufferSize = 1 << 16;
    private final byte buffer[] = new byte[bufferSize];
    private final BufferedInputStream in;

    private int bufferPosition = 0;
    private int totalInBuffer = 0;

    public FastReader(final InputStream stream) {
        in = new BufferedInputStream(stream, bufferSize);
    }

    public int nextInt() {
        int ch = nextChar();
        while (ch <= ' ') {
            ch = nextChar();
        }

        int value = 0, sign = 1;
        if (ch == '-') {
            sign = -1;
            ch = nextChar();
        }

        while (ch >= '0') {
            value = value * 10 + (ch - '0');
            ch = nextChar();
        }
        return value * sign;
    }

    public int nextChar() {
        if (bufferPosition == totalInBuffer) {
            try {
                totalInBuffer = in.read(buffer, 0, bufferSize);
            } catch (IOException e) {
                System.out.println("Error reading from the input stream");
            }
            bufferPosition = 0;
        }
        return bufferPosition >= totalInBuffer ? -1 : buffer[bufferPosition++];
    }
}

class FastWriter {
    private static final String newLine = System.getProperty("line.separator");
    private final int bufferSize = 1 << 16;
    private final byte buffer[] = new byte[bufferSize];
    private final BufferedOutputStream out;
    private int bufferPosition;

    public FastWriter(final OutputStream stream) {
        out = new BufferedOutputStream(stream, bufferSize);
        bufferPosition = 0;
    }

    public void print(int x) {
        byte c[] = new byte[20];
        int cn = 0;
        if (bufferPosition + 20 >= bufferSize)
            flush();
        if (x < 0) {
            buffer[bufferPosition++] = (byte) ('-');
            x = -x;
        }
        while (cn == 0 || x != 0) {
            c[cn++] = (byte) (x % 10 + '0');
            x /= 10;
        }
        while (cn-- > 0)
            buffer[bufferPosition++] = c[cn];
    }

    public void print(char x) {
        if (bufferPosition == bufferSize) {
            flush();
        }
        buffer[bufferPosition++] = (byte) x;
    }

    public void print(String s) {
        for (int i = 0; i < s.length(); i++)
            print(s.charAt(i));
    }

    public void println(String s) {
        print(s);
        println();
    }

    private void println() {
        print(newLine);
    }

    public void close() {
        flush();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void flush() {
        try {
            out.write(buffer, 0, bufferPosition);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferPosition = 0;
    }
}
