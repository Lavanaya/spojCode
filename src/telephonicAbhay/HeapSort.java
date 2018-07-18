package telephonicAbhay;

public class HeapSort {

    public void heapsort(int[] a){
        int n=a.length;
        for(int i=n/2-1;i>=0;i--)
            heapify(a,n,i);

        for(int i=n-1;i>=0;i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a,i,0);
        }
    }

    public void heapify(int[] a,int n,int i){

        int largest=i;
        int left=i*2+1;
        int right=i*2+2;

        if(left<n&&a[left]>a[largest])
            largest=left;
        if (right<n&&a[largest]<a[right])
            largest=right;

        if(largest!=i){
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;
            heapify(a,n,largest);
        }

    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
       ob.heapsort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
