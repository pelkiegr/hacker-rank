import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        // X: the integer to sum to
        // N: the integer power to raise numbers to
        
        return powerCalc(X, N, 1);
    }

    static int powerCalc(int x, int n, int num) {
        int pow = (int) Math.pow(num, n);
        if (pow > x) {
            return 0;
        } else if (pow == x) {
            return 1;
        } else {
            return powerCalc(x, n, num + 1) + powerCalc(x - pow,  n, num + 1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
