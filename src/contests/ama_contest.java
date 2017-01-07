package contests;

import java.util.ArrayList;
import java.util.Scanner;

class ama_contest {
 	int mark[];
	long knowledge[];
	ArrayList<Integer> a[];
	long maxKnowledge;	
	int x2;

	public ama_contest(int n){
		knowledge= new long[n];
		a= new ArrayList[n];
		for(int i=0;i<n;i++)
			a[i]=new ArrayList<Integer>();
		mark= new int[n];
	}
void dfs(int u)
{
	mark[u]=1;
	if(knowledge[u]>maxKnowledge)
    {
        maxKnowledge=knowledge[u];
        x2=1;
    }
    else
    {
        if(knowledge[u]==maxKnowledge)
            x2++;
    }
	for(int i=a[u].size()-1;i>=0;i--)
	{
		int v=a[u].get(i);
		if(mark[v]==0) dfs(v);
	}
}

public static void main(String[] args) {

	int n,m;
	Scanner sc= new Scanner(System.in);
	 n=sc.nextInt();
    
     m=sc.nextInt();
     ama_contest algo= new ama_contest(n);
		for(int i=0;i<n;i++){
            algo.knowledge[i]=sc.nextLong();
			algo.mark[i]=0;
        }
		int i,u,v;
		long mul=1;
		for(int k=0;k<m;k++)
		{
			u=sc.nextInt();
			v=sc.nextInt();
			algo.a[u-1].add(v-1);
			algo.a[v-1].add(u-1);
		}
		for(i=0;i<n;i++)
			if(algo.mark[i]==0)
			{
				algo.x2=1;
                algo.maxKnowledge=-1;
				algo.dfs(i);
				mul= (mul*algo.x2)%1000000007;
			}
		System.out.println(mul);
}
}
