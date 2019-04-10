import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long length = s.length();

        long multiplier = n / length;
        int remainder = (int) (n % length);

        if (length > n) {
            return calcCharCount(s.substring(0, remainder), 'a');
        } else {
            return calcCharCount(s, 'a') * multiplier + calcCharCount(s.substring(0, remainder), 'a');
        }
    }

	private static long calcCharCount(String s, char letter) {
		long numA = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                numA++;
            }
        }
        return numA;
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
