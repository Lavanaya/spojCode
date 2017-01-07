package LeetCode;

import java.util.*;

public class combination {

	static int targetLength=2;
	static int n;
	public static void main(String[] args) {
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> tempList=new ArrayList<>();
		n=4;
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=i+1;
		
		System.out.println(dfs(0,a,0,list,tempList));
	}
	public static  List<List<Integer>> dfs(int start,int[] a,int sum,List<List<Integer>> list,List<Integer> tempList)
	{	
		List<Integer> tempList2=new ArrayList<>(tempList);
		//Collections.sort(tempList2);
		if( targetLength==tempList2.size() )
		{
			//tempList2.add(sum);
					list.add(tempList2);
					//System.out.println(list);
				
			return list;
		}
		else if (start==a.length)
			return list;
		else{
			for(int i=start;i<a.length;i++){
				tempList.add(a[i]);
				dfs(i+1,a,sum+a[i],list,tempList);
				tempList.remove(tempList.size()-1);
			//	dfs(i+1,a,sum,list,list.remove(tempList.size()-1));
			}
			return list;
		}
	}

}
