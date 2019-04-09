import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String init = s.substring(0, k);
        String smallest = init;
        String largest = init;
        

        for (int i = 0; i <= s.length() - k; i++) {
            String current = s.substring(i, i + k);
            
            if (smallest.compareTo(current) > 0) {
                smallest = current;
            }
            if (largest.compareTo(current) < 0) {
                largest = current;
            }
        }
        
        return smallest + "\n" + largest;
    }

