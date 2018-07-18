package telephonicAbhay;


import java.util.Random;

//Random pivot element
public class QuickSort {
    public static void main(String[] args) {
        int[] a={10, 7, 8, 9, 1, 5};

        quicksort(a,0,a.length-1);
        int n = a.length;
        for (int i=0; i<n; ++i)
            System.out.print(a[i]+" ");
        System.out.println();
    }

    private static void quicksort(int[] a, int start,int end){
        if(start<end)
        {
            System.out.println(start);
            int partition =  partition(a,start,end);
           // System.out.println(partition);
            quicksort(a,start,partition-1);
            quicksort(a,partition+1,end);
        }
    }

    private static int partition(int[] a, int start,int end){
        Random random=new Random();
        int pivIndex=random.nextInt(end-start)+start;

        System.out.println("pivot "+pivIndex);
        int piv=a[pivIndex];
        swap(a,pivIndex,start);//8 i=1 j=1 j<=5

        int i=start+1;
        for(int j=start+1;j<=end ;j++){
            if(a[j] < piv)
            {
                swap(a,i,j);
                i++;
            }
        }
        //swap piv with start index
        swap(a,start,i-1);
        return i-1;
    }

    private static void swap(int[] a,int b,int c){
        if(b<a.length && c<a.length){
        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;}
    }
}
