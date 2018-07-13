package dp;

public class subsetSumRec {

    public static void main(String[] args) {

        System.out.println( getPossibleCoinChangesNoRec(13, new int[]{3,34,4,12,5,2},5));
        System.out.println(getPossibleCoinChangesNoDp(31, new int[]  {3,34,4,12,5,2}));
    }

    public  static boolean getPossibleCoinChangesNoRec(int sum, int[] a, int size){
        if(sum==0) {return true;
        }
        else  if(sum<0 || size<0) return false;
        return getPossibleCoinChangesNoRec(sum-a[size],a,size-1) || getPossibleCoinChangesNoRec(sum,a,size-1);
    }


    public static boolean getPossibleCoinChangesNoDp(int sum,int[] a) {
        boolean[][] dp = new boolean[sum+1][a.length];
        //dp[0][] = true;
        for (int i = 0; i < dp[0].length; i++)
            dp[0][i] = true;

        for(int j=0;j< a.length;j++){
        for(int i=1;i<=sum;i++){

                boolean with= (i-a[j])>=0 && (j>0) ? dp[i-a[j]][j-1]:false;
                boolean without =  (j>0) ?dp[i][j-1]:false;
         //   System.out.println(with + " ;  "+without + " ;  "+i+ " ;  "+j+ " ;  ");
                dp[i][j] = with || without;
            }
        }
        return dp[sum][a.length-1];

/*
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < sum + 1; j++) {

                boolean with = (j - a[i]) >= 0 ? dp[j - a[i]] : false;
                boolean without = dp[j];
                dp[j] = with || without;

            }
        }*/


    }

}
