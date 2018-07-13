package dp;

public class CoinChangeDP {


    public static void main(String[] args) {

        CoinChangeDP coinChange =new CoinChangeDP();
        int[][] dp=new int[6][3];
        for(int i=0;i<3;i++){

                dp[0][i]=1;

        }
        int[] dp2=new int[5+1];
        dp2[0]=1;
        for(int i=1;i<dp2.length;i++)
            dp2[i]=0;
        System.out.println( coinChange.getPossibleCoinChangesNo(5, new int[]{1,2,3},dp));
        System.out.println("1D:  "+coinChange.getPossibleCoinChangesNo1D(5,new int[]{1,2,3},dp2));

    }

    public  int getPossibleCoinChangesNo(int sum, int[] a, int[][] dp){

        for(int i=1;i<=sum;i++){
            for(int j=0;j< a.length;j++){
                int with= (i-a[j])>=0 ?dp[i-a[j]][j]:0;
                int without =  (j>0)?dp[i][j-1]:0;
                dp[i][j] = with + without;
               // System.out.println(dp[i][j]);
            }
        }
         return dp[sum][a.length-1];
    }


    public  int getPossibleCoinChangesNo1D(int sum, int[] a, int[] dp){


        for(int i=0;i<a.length;i++){
            for(int j=1;j<sum+1;j++){

                int with= (j-a[i])>=0 ? dp[j-a[i]]:0;
                int without =  dp[j];
                dp[j] = with + without;

            }

        }

       /** u need to calculate value of each sum for every single coin before including other coins ic (n-1) should be
       calculated before including nth coin as vice versa is done than  value for without including coin cant be calculated

        **/
       /*
       for(int i=1;i<=sum;i++){
            for(int j=0;j< a.length;j++){
                int with= (i-a[j])>=0 ? dp[i-a[j]]:0;
                int without =  (j>0)?dp[i]:0;
               dp[i] = with + without;
              //  dp[i]=with;
                System.out.print(dp[i]+"  ");
            }
            System.out.println();
        }*/

        System.out.println("coins change no: "+ dp[sum]);
        return dp[sum];
    }
}
