package LeetCode;

public class median_of_two_sorted_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={0};
		int[] b={3,4,5};
		median(a,b);
	}
	public static int median(int[] a,int[] b){
		int l1=a.length;
		int l2=b.length;
		int l3=l1+l2;
		System.out.println(l3);
		int median=0;
		if(l3%2==0)
			median=l3/2;
		else
			median=(l3/2);
		System.out.println(median);
		int[] c=mergeSort(a,b,median);
	//	System.out.println(c[3]);
		double result;
		if(l3%2==0)
		{ result=(c[median]+c[median-1])/2d;
		System.out.println((c[median]+c[median-1]));
			System.out.println(result);}
		else
			System.out.println(c[median]);
		return 0;
	}

	public static int[] mergeSort(int[] a,int[] b,int median){
		int[] c=new int[10000];
		int i=0,j=0,k=-1;
		for( i=0,j=0;i<a.length && j<b.length;){
			if(a[i]>b[j])
				{ c[++k]=b[j];j++;}
			else if(a[i]<b[j])
			{
				c[++k]=a[i];i++;
			}
			else
			{
				c[++k]=a[i];
				c[++k]=b[j];
				i++;j++;
				}
			
		if(k>median || k==median){
			break;
		}
		}
		if(k<median){
		while(i!=a.length)
			{c[++k]=a[i];i++;}
		}
		if(k<median)
		while(j!=b.length)
			{c[++k]=b[j];j++;}
		
		System.out.println(c[2]);
		return c;
	}
}
