package Algorithms.BitManipulation.CounterGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final String RICHARD = "Richard";
    private static final String LOUISE = "Louise";

    // Complete the counterGame function below.
    static String counterGame(long n) {

        long number = n;

        int iterations = 0;
        while (number != 1) {
            long highestBit = Long.highestOneBit(number);

            if (highestBit == number) {
                number = number / 2;
            } else {
                number = number - highestBit;
            }
            iterations++;
        }

        if (iterations % 2 == 0) {
            return RICHARD;
        } else {
            return LOUISE;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = counterGame(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

