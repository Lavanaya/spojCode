package heap;

public class HeapSort {

    /**
     * max heap
     */

    static int size=0;


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] a=new int[]{12,11,13,5,6,7};
        size=a.length;
         //heapSort.
        heapSort(a);
    }

    public static void heapSort(int[] a)
    {
        int n=a.length;
        if(n<2) return ;

        for(int i=n/2; i>=0;i--)
            heapify(a,i,n);

        for(int i=n-1;i>=0;i--){
          //  swap(a[0], a[i]);

            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify(a,0,i);
        }

        for (int a1:a)
        System.out.println(a1);
    }


    public static void heapify(int[] a,int s,int e){
       // if(s==e) return;
        int largest=s, left=2*s+1,right=2*s+2;

        // If left child is larger than root
        if (left < e && a[left] > a[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < e && a[right] > a[largest])
            largest = right;

        // If largest is not root
        if (largest != s)
        {
            System.out.println(a[s]+":"+a[largest]);
           // swap(a[s], a[largest]);
            int temp=a[s];
            a[s]=a[largest];
            a[largest]=temp;
            System.out.println("after: "+a[s]+":"+a[largest]);

            // Recursively heapify the affected sub-tree
            heapify(a, largest,e);
        }

    }


    public int extractMin(int[] a){
        int min=a[0];

        a[0]=a[size-1];

        heapify(a,0,size);
        return min;
    }
    public void insert(int[] a,int v){

        a[size]=v;
        size++;
        if(a[(size-1)/2] >v )
            heapify(a,(size-1)/2,size);
    }

/*
    public static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
        System.out.println(a);
        System.out.println(b);

    }
    */



}
