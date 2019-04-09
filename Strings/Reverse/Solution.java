import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        System.out.println(isPalindrome(A) ? "Yes" : "No");
    }

    private static boolean isPalindrome(String str) {
        char[] arr = str.toCharArray();

        int length = str.length();
        for (int i = 0; i < length/2; i ++) {
            if (arr[i] != arr[length - i - 1]) {
                return false;
            }
        }

        return true;
    }
}
