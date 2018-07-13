package dp;

public class LongestSubSequenceRec {


    public static void main(String[] args) {

        String s1="saturdays";
        String s2="sunsday";
        int result = longestSubsequence(s1.toCharArray(),s2.toCharArray(),0,0);
        System.out.println(result);


    }


    private static int longestSubsequence(char[] s1,char[] s2,int i,int j){

        if(s1.length==i || s2.length==j || i<0||j<0) return 0;

        if(s1[i]==s2[j]) return 1+longestSubsequence(s1,s2,i+1,j+1);

        else {
            return Math.max(longestSubsequence(s1,s2,i+1,j), longestSubsequence(s1,s2,i,j+1));
        }

    }
}
