import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BigInteger n1 = scanner.nextBigInteger();
        BigInteger n2 = scanner.nextBigInteger();

        BigInteger sum = n1.add(n2);
        BigInteger product = n1.multiply(n2);

        System.out.println(sum);
        System.out.println(product);
    }
}