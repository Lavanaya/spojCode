package array;

/**
 * rearrange positive negative elements such with positive at even index and negative at odd index
 */
public class reaarangePosNeg {


    public static void main(String[] args) {
        int[] a={-2,1,3,4,-3,-1};
        //start positive index from 0 and negative element index from 1 and  increment by 2
        int n=1,p=0;
        while(n<a.length && p<a.length-1){
            if(a[p]<0){ //if positive element is at even index

                while(n< a.length && a[n]<0  ){ //found displaced element
                    n=n+2;
                }
                if(n<a.length && a[n]>0)
                {
                    //if negative no found at even index swap  with positive element at odd index
                    int t=a[p];
                    a[p]=a[n];
                    a[n]=t;
                    n=n+2;
                }

            }
            p=p+2;
        }
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}
