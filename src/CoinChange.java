import java.util.HashMap;

public class CoinChange {

    HashMap
    static  int count=0;
    public static void count(int sum,int[] a,int st){
        if(sum==0){
            System.out.println(st);
            count++;
            return;
        }
        else if(sum<0) return;
        else{
            for(int i=st;i<a.length;i++){
                if(!(a[i]>sum))
                    count(sum-a[i],a,i);
                count(sum,a,i+1);
            }
            return;
        }
    }

    public static void main(String[] args) {
        int[] a ={1,2,3};int sum=4;
        CoinChange.count(sum,a,0);
        System.out.println(count);
    }
}
