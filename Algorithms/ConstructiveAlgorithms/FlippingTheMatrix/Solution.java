import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingMatrix function below.

    //TODO not working
    static int flippingMatrix(int[][] matrix) {

        int n = matrix.length / 2;

        int colIndex = 0;
        int maxColDifference = 0;
        for (int row = 0; row < matrix.length; row++) {
            int currentDiff = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (i <  n) {
                    currentDiff -= matrix[row][i];
                } else {
                    currentDiff += matrix[row][i];
                }
            }
            if (currentDiff > maxColDifference) {
                maxColDifference = currentDiff;
                colIndex = row;
            }
        }

        int rowIndex = 0;
        int maxRowDifference = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            int currentDiff = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (i <  n) {
                    currentDiff -= matrix[i][col];
                } else {
                    currentDiff += matrix[i][col];
                }
            }
            if (currentDiff > maxRowDifference) {
                maxRowDifference = currentDiff;
                rowIndex = col;
            }
        }

        if (maxColDifference > maxRowDifference) {
            // Flip column
            reverse(matrix[colIndex]);
        } else {
            for (int i = 0; i < matrix[colIndex].length / 2; i++) {
                int temp = matrix[colIndex][i];
                matrix[colIndex][i] = matrix[colIndex][matrix[colIndex].length - i - 1];
                matrix[colIndex][matrix[colIndex].length - i - 1] = temp;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
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
