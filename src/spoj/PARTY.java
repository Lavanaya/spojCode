package spoj;

import java.util.Scanner;
import java.math.*;

public class PARTY {

	static int weight[],value[];
	static int wt,n,wt0=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//KNAP-SACK PROBLEM
		Scanner sc=new Scanner(System.in);
		while(true){
			
		wt=sc.nextInt();
		n=sc.nextInt();
		if(wt==0&&n==0)
			break;
		weight=new int[n+1];
		value=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			weight[i]=sc.nextInt();
			value[i]=sc.nextInt();
		}
		System.out.println(wt0+" "+knapsack(wt,weight,value,n));
		}
	}
	
	
	public static int knapsack(int w,int[] weight,int[] value,int n){
		if(w==0||n==0)
		return 0;
		else if(weight[n]>w)
			return knapsack(w, weight, value, n-1);
		else
		{
			wt=wt+weight[n];
			int withValue=value[n]+knapsack(w-weight[n], weight, value, n-1);
			int withoutValue=knapsack(w, weight, value, n-1);
			
			if(withValue < withoutValue)
				wt0= wt0-weight[n];
			return Math.max(withValue,withoutValue);
		}
	}

}
