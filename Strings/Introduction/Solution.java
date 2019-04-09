import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");

        StringBuilder builder = new StringBuilder();
        builder.append(A.substring(0, 1).toUpperCase())
                .append(A.substring(1))
                .append(" ")
                .append(B.substring(0, 1).toUpperCase())
                .append(B.substring(1));

        System.out.println(builder.toString());

        sc.close();
    }
}
