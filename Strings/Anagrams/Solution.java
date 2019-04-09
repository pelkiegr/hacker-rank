import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] aChars = a.toLowerCase().toCharArray();
        char[] bChars = b.toLowerCase().toCharArray();

        int[] charCounts = new int[26];

        for (int i = 0; i < aChars.length; i++) {
            charCounts[aChars[i] - 97]++;
            charCounts[bChars[i] - 97]--;
        }

        for (int i : charCounts) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}