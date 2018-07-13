package dp;

public class CoinChange {
    static int count=0;
    public static void main(String[] args) {
        CoinChange coinChange =new CoinChange();
        System.out.println( coinChange.getPossibleCoinChangesNo(4, new int[]{1,2,3},2));
        System.out.println(count);


    }

    public  int getPossibleCoinChangesNo(int sum, int[] a, int size){
           if(sum==0) {count++;
               return  1;}
           else  if(sum<0 || size<0) return 0;
           return getPossibleCoinChangesNo(sum-a[size],a,size) + getPossibleCoinChangesNo(sum,a,size-1);
    }




}


