package telephonicAbhay;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*Inversion Count for an array indicates – how far (or close) the array is from being sorted.
        If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum.
        Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
Example:
        The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
*/
class mergerSort {

    static BigInteger count=BigInteger.valueOf(0);
    public static void sort(int[] a,int l,int r){
        if (l < r)
        {
            int mid = (l+r)/2;
            sort(a, l, mid);
            sort(a , mid+1, r);

            merge(a, l, mid, r);
        }
    }

    public static void merge(int[] a,int l,int m,int r){
        int n1 = m - l + 1;
        int n2 = r - m;

        int[]  A=  Arrays.copyOfRange(a,l,m+1);

        int[]  B=  Arrays.copyOfRange(a,m+1,r+1);

        int i = 0, j = 0,k = l;
        while (i < n1 && j < n2)
        {

            if (A[i] <= B[j])
            {
                a[k] = A[i];
                i++;
            }
            else
            {
                a[k] = B[j];
                // System.out.println("here");
                count=count.add(BigInteger.valueOf(n1-i));
                j++;
            }
            k++;
        }


        while (i < n1)
        {
            a[k] = A[i];
            i++;
            k++;
        }


        while (j < n2)
        {
            a[k] = B[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int[] a=new int[n];

            for(int j=0;j<n;j++)
                a[j]=sc.nextInt();

            sort(a,0,a.length-1);
            System.out.println(count);

            count=BigInteger.ZERO;
        }

    }
}

  /* mergerSort.sort(new int[]{9,1,7,4,2,29},0,5);
        System.out.println(count);

        count=0;
        mergerSort.sort(new int[]{9,1},0,1);
        System.out.println(count);

        count=0;
        mergerSort.sort(new int[]{9,1,5},0,2);
        System.out.println(count);*/

//9,1,7,4,2,29
