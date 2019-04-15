import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingMatrix function below.

    static int flippingMatrix(int[][] matrix) {

        int n = matrix.length / 2;

        int sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int topLeft = matrix[row][col];
                int topRight = matrix[row][(2*n) - col - 1];
                int botLeft = matrix[(2*n) - row - 1][col];
                int botRight = matrix[(2*n) - row - 1][(2*n) - col - 1];

                sum += Math.max(Math.max(topLeft, topRight), Math.max(botLeft, botRight));
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] matrix = new int[2*n][2*n];

            for (int i = 0; i < 2*n; i++) {
                String[] matrixRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2*n; j++) {
                    int matrixItem = Integer.parseInt(matrixRowItems[j]);
                    matrix[i][j] = matrixItem;
                }
            }

            int result = flippingMatrix(matrix);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
