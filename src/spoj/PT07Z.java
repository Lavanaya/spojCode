package spoj;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class PT07Z {
	private static  Map<Integer, List<Integer>> Adjacency_List;
	private static BufferedReader f;
	//private int maxPathHeight=0;
	static int[] visited;
	static int[] maxResult=new int[10001];
	static int[] q=new int[10000];int j=0;
	static int maxInner=0;
	
	public static void main(String[] args) throws IOException {
		PT07Z pt=null;
		StringTokenizer st;
		f = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(f.readLine());
		pt=new PT07Z(t+1);
		int finalResult=0;
		/*pt.setEdge(1,2);
		pt.setEdge(1,3);
		pt.setEdge(1,4);
		pt.setEdge(2,5);
		pt.setEdge(6,2);
		pt.setEdge(6,7);
		pt.setEdge(6,8);
		pt.setEdge(7,9);
		pt.setEdge(7,10);
		pt.setEdge(8,11);
		pt.setEdge(11,13);
		pt.setEdge(13,15);
		pt.setEdge(15,16);
		pt.setEdge(10,12);
		pt.setEdge(12,14);
	*/
		
	for(int i=0;i<t-1;i++)
		{
			st= new StringTokenizer(f.readLine());
			int source=parseInt(st.nextToken());
			int dest=parseInt(st.nextToken());
			pt.setEdge(source,dest);
		}
		
		Set<Integer> keySet=Adjacency_List.keySet();
		Iterator<Integer> iterator=keySet.iterator();
		while(iterator.hasNext())
		{
			int node=iterator.next();
			if(Adjacency_List.get(node).size()==1)
			{
				visited=new int[10001];
				int result = pt.caculateHeight(node);
				if(result > finalResult)
				finalResult = result;
				break;
			}
		}
	
		if(finalResult>0)
			finalResult=finalResult-1;
		if(maxInner-2>finalResult)
		System.out.println("innermax"+(maxInner-2));
		else {
			System.out.println(finalResult);
		}
	}

	public PT07Z(int number_of_vertices)
    {
        Adjacency_List = new HashMap<Integer, List<Integer>>();
    }
	
	 public void setEdge(int source , int destination)
	    {
	    // System.out.println(source+"   " +destination+"  "+Adjacency_List);  
	     if(!Adjacency_List.containsKey(source))
	    	 Adjacency_List.put(source, new LinkedList<Integer>());
	     if(!Adjacency_List.containsKey(destination))
	    	 Adjacency_List.put(destination, new LinkedList<Integer>());
	     List<Integer> slist = Adjacency_List.get(source);
	     slist.add(destination);
	     Adjacency_List.put(source, slist);
	     List<Integer> dlist = Adjacency_List.get(destination);
	     dlist.add(source);
	     Adjacency_List.put(destination, dlist);
	    }
	 
	 public int caculateHeight(int node){
		 int maxPathHeight=0;
		 List<Integer> srcList = Adjacency_List.get(node);
		 boolean flag=false; //flag to see if leaf node or inner node
		 visited[node]=1;
		 for(int i=0;i < srcList.size();i++)
			{
				if(visited[srcList.get(i)]!=1)
				{
					flag=true;
					int distance=caculateHeight(srcList.get(i))+1;
					if(maxPathHeight+distance>maxInner)
						maxInner = maxPathHeight+distance;
					if(maxPathHeight < distance)
					{
						maxPathHeight = distance;		
					}
					
				}
			}
			if(flag==false)//if all nodes were visited
			{	
				return 1;
			}
		
		return maxPathHeight;
		 
	 }
	 
	 
}
