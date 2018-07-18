package telephonicAbhay;

 class InsertionSort
{
    /* Insertion Sort function */
    public static void sort( int arr[] )
    {
        int n= arr.length;
       for(int j=1;j< n; j++){
           int i=j;
           int key=arr[j];
           if(arr[j-1]>key){
               while(j>0 && arr[j-1]>key){
                   System.out.println(arr[j-1]+" "+key);
                   arr[j]=arr[j-1];
                   arr[j-1]=key;
                   j--;
               }
           }
           j=i;
       }
    }
    /* Main method */
    public static void main(String[] args)
    {
        int arr[] = {2,4,1,3,5};

        sort(arr);

        int arr2[] = {9,2,4,1,7,5};

        sort(arr2);

        System.out.println("\nElements after sorting ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}