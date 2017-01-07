package spoj;
import java.util.*;

public class HPYNOS {
	static HashMap<Integer,Integer> visited;
	static int count=0;
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		visited=new HashMap<>();
		
		System.out.println(fn(n,0));
	}

	public static int fn(int n,int sum){
		
		while(!visited.containsKey(n))
		{
			visited.put(n,1);
			while(n>0){
				sum=sum+(int)Math.pow(n%10, 2);
				n=n/10;
			}
			count++;
			if(sum==1)
				return count;
			else
				{
					n=sum;
					sum=0;
				}
		}
		return -1;
	}
}
