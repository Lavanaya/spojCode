package LeetCode;

import java.util.Arrays;

public class medianSortedArray_optimized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1};
		int[] b={3,4,5};
		System.out.println(median(a,b));
	}
	
	public static double median(int[] nums1,int[] nums2){
		return findMedian(nums1,nums1.length,nums2,nums2.length);
	}
	
	public static double MO2(int a, double d)
	{ return ( a + d ) / 2.0; }

	public static double MO3(int a, int b, int c)
	{
		return a + b + c - Math.max(a, Math.max(b, c))
						- Math.min(a, Math.min(b, c));
	}

	public static double MO4(int a, int b, int c, int d)
	{
		int max = Math.max( a, Math.max( b, Math.max( c, d ) ) );
		int min = Math.min( a, Math.min( b, Math.min( c, d ) ) );
		return ( a + b + c + d - max - min ) / 2.0;
	}

	public static double medianSingle(int arr[], int n)
	{
	if (n == 0)
		return -1;
	if (n%2 == 0)
			return (double)(arr[n/2] + arr[n/2-1])/2;
	return (double)arr[n/2];
	}

	public static double findMedianUtil( int A[], int N, int B[], int M )
	{
	   	if (N == 0)
		return medianSingle(B, M);

		if (N == 1)
		{
			if (M == 1)
				return MO2(A[0], B[0]);

			if (M % 2!=0)
				return MO2( B[M/2], MO3(A[0], B[M/2 - 1], B[M/2 + 1]) );

			return MO3( B[M/2], B[M/2 - 1], A[0] );
		}

		else if (N == 2)
		{
			if (M == 2)
				return MO4(A[0], A[1], B[0], B[1]);
		if (M % 2!=0)
				return MO3 ( B[M/2],
							Math.max(A[0], B[M/2 - 1]),
							Math.min(A[1], B[M/2 + 1])
						);

			return MO4 ( B[M/2],
						B[M/2 - 1],
						Math.max( A[0], B[M/2 - 2] ),
						Math.min( A[1], B[M/2 + 1] )
					);
		}

		int idxA = ( N - 1 ) / 2;
		int idxB = ( M - 1 ) / 2;
	   

		if (A[idxA] <= B[idxB] )
		{
		    return findMedianUtil(Arrays.copyOfRange(A, idxA, A.length), N/2 + 1, B, M - idxA );}

		{return findMedianUtil(A, N/2 + 1,Arrays.copyOfRange(B, idxA, B.length), M - idxA );}
	}
	public static double findMedian( int A[], int N, int B[], int M )
	{
		if (N > M)
		return findMedianUtil( B, M, A, N );

		return findMedianUtil( A, N, B, M );
	}

}
