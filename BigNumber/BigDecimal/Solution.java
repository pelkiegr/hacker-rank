import java.math.BigDecimal;
import java.util.*;

class Solution {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        Scanner sc2 = sc;
		int n=sc2.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc2.next();
        }
        sc2.close();

        Comparator<String> comparator = (String s1, String s2) -> new BigDecimal(s2).compareTo(new BigDecimal(s1));

        Arrays.sort(s, 0, n, comparator);

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}