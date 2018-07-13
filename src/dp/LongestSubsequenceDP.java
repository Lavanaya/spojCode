package dp;

import java.util.Arrays;

public class LongestSubsequenceDP {

    public static void main(String[] args) {
        String s1="saturday";
        String s2="sunday";
        int result = longestSubsequence(s1.toCharArray(),s2.toCharArray());
        System.out.println(result);

        if(s1.length()>s2.length())
            System.out.println(s1.length()-result);
        else
            System.out.println(s2.length()-result);

    }

    public static int longestSubsequence(char[] s1,char[] s2){
        int n1=s1.length;
        int n2=s2.length;
        int[][] l= new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++)
            Arrays.fill(l[i],0);

       /* for(int i=0;i<n1;i++){
            for(int j)
        */
       int i=1,j=1;

       //while(i<=n1&& j<=n2)
        for( i=1;i<=n1;i++)
        for(j=1;j<=n2;j++)
       {
           if(s1[i-1]==s2[j-1])
            l[i][j]   = 1+ l[i-1][j-1];
           else
               l[i][j]=Math.max(l[i][j-1],l[i-1][j]);
       }
       return l[n1][n2];
    }
}
