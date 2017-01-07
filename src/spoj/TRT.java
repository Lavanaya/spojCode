package spoj;
import java.math.*;
import java.util.*;
public class TRT {
	public static int maxSum=0;
	static int[][] visited;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t =sc.nextInt();
		ArrayList<Integer> arr=new ArrayList<>();
		visited=new int[2001][2001];
		for(int i=0;i<t;i++)
			for(int j=0;j<t;j++)
				visited[i][j]=-1;
		while(t!=0){
			arr.add(sc.nextInt());
			t--;
		}
		System.out.println(maxCost(arr,1,0,arr.size()-1));
	}
	public static int maxCost(List<Integer> arr,int age,int start,int end){
	
		if(start>end)
			return 0;
		else if(visited[start][end]!=-1){
				return visited[start][end];}
		else{
			int a=maxCost(arr,age+1,start+1,end) + age*arr.get(start);
			int b=maxCost(arr,age+1,start,end-1) + age*arr.get(end);
			visited[start][end]=Math.max(a,b);
			return Math.max(a,b);
		}
	}

}

