import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cost function below.
    static int cost(int[] B) {

        // TODO brute force / incomplete

        int[] arrLowStart = new int[B.length];
        int[] arrHighStart = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            if (i == 0 || i %2 == 0) {
                arrLowStart[i] = 1;
                arrHighStart[i] = B[i];
            } else {
                arrHighStart[i] = 1;
                arrLowStart[i] = B[i];
            }
        }

        int lowMax = 0;
        int highMax = 0;

        for (int i = 1; i < B.length; i++) {
            lowMax += Math.abs(arrLowStart[i] - arrLowStart[i - 1]);
            highMax += Math.abs(arrHighStart[i] - arrHighStart[i - 1]);
        }

        return Math.max(lowMax, highMax);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
