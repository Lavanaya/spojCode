package telephonicAbhay;

public class BubbleSort {

    private static  void bubbleSort(int[] a){
        int j=a.length-1;
        for(int n=0;n<=j;n++){

            for(int i=1;i<=j-n;i++){
                if(a[i]<a[i-1])
                {
                    swap(a,i,i-1);
                }

            }

        }
    }


    private static void swap(int[] a,int b,int c){
        if(b<a.length && c<a.length){
            int temp=a[b];
            a[b]=a[c];
            a[c]=temp;}
    }

    public static void main(String[] args) {
        int[] a={10, 7, 8, 9, 1, 5};

        bubbleSort(a);
        int n = a.length;
        for (int i=0; i<n; ++i)
            System.out.print(a[i]+" ");
        System.out.println();
    }
}
