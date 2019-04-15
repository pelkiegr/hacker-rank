import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        Comparator<String> comparator = (s1, s2) -> compareStringIntegers(s1, s2);

        Arrays.sort(unsorted, comparator);

        return unsorted;
    }

    /**
     * Compare strings as integers.
     * 
     * @return 1 if s1 is larger, -1 if s2 is larger, 0 if they are equal
     */
    private static int compareStringIntegers(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return 1;
        }
        if (s2.length() > s1.length()) {
            return -1;
        }

        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (s1Chars[i] > s2Chars[i]) {
                return 1;
            }
            if (s2Chars[i] > s1Chars[i]) {
                return -1;
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]);

            if (i != result.length - 1) {
                builder.append("\n");
            }
        }

        bufferedWriter.write(builder.toString());

        bufferedWriter.close();

        scanner.close();
    }
}
