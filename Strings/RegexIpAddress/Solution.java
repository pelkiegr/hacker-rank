import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {
    private static final String NUM_REGEX = "(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])"; 
    static final String pattern = "(" + NUM_REGEX + "\\.){3}" + NUM_REGEX;
}