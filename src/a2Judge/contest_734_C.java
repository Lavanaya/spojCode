package a2Judge;
import java.util.*;
public class contest_734_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		
		int x=sc.nextInt();
		int s=sc.nextInt();
		
		int[] a=new int[m];
		int[] b=new int[m];
		int[] c=new int[k];
		int[] d=new int[k];
		
		for(int i=0;i<m;i++)
			a[i]=sc.nextInt();
		for(int i=0;i<m;i++)
			b[i]=sc.nextInt();
		
		for(int i=0;i<k;i++)
			c[i]=sc.nextInt();
		for(int i=0;i<k;i++)
			d[i]=sc.nextInt();
		
		int points=0,time=0,remS=0;
		int minTime=Integer.MAX_VALUE;
		for(int i=k-1;i>-1;i--){
			if(d[i]<=s )
			{
				points=points+d[i];
				remS=s-points;
			}
			for(int j=0;j<m;j++){
				
			}
			
		}
		
		
		
		
		
		

	}

}
