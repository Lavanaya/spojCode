package spoj;

import java.util.Scanner;

public class FARIDA {
	static long[] a,dp;
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int j=0;j<t;j++){
		n=sc.nextInt();
		a=new long[n];
		dp=new long[n];
		for(int i=0;i<n;i++)
		{
			
			a[i]=sc.nextLong();
			dp[i]=-1l;}
		System.out.println("Case "+(j+1)+": "+solve(0));
		}
	}

	public static long  solve(int i){
		if(i>=n)
		  return 0;
		if(i==n-1)//if it is the last monster ,you have to choose it coz our aim is to maximize the coin sum
		  return a[i];
		if(dp[i]!=-1)
		      return dp[i];
		dp[i]=Math.max(a[i]+solve(i+2),solve(i+1));
	   
	    //if you choose the ith monster's coins you cannot choose the next so you 
	    //move to the i+2th monster. if you do not choose the ith monster's coins you still have a chance to choose i+1th monster's 
	    //coins.So you move to i+1th monster 
	    
	    return dp[i];
	}
}
