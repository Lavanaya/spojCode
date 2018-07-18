package telephonicAbhay;

import java.util.Arrays;

public class CountingSort {


    public static void main(String[] args) {
        countingsort(new int[]{5,2,9,5,2,3,5});
    }
    public static void countingsort(int[] a){
        int n=a.length, maxElem=Integer.MIN_VALUE;
        //find max
        for(int i=0;i<n;i++)
            if(maxElem<a[i])
                maxElem=a[i];

        int[] aux=new int[maxElem+1];
        Arrays.fill(aux,0);
        for(int i=0;i<n;i++)
            aux[a[i]]++;

        for(int i=0;i<aux.length;i++){
            if(aux[i]!=0)
            {
                while(aux[i]-->0)
                System.out.println(i);
            }
        }

    }
}
