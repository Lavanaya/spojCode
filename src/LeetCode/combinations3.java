package LeetCode;

import java.util.*;

public class combinations3 {

	static int targetLength=3;
	static int target=9;
	public static void main(String[] args) {
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> tempList=new ArrayList<>();
		int[] a={1,2,3,4,5,6,7,8,9};
		System.out.println(dfs(0,a,0,list,tempList));
	}
	public static  List<List<Integer>> dfs(int start,int[] a,int sum,List<List<Integer>> list,List<Integer> tempList){	
		List<Integer> tempList2=new ArrayList<>(tempList);
		Collections.sort(tempList2);
		if(sum==target && targetLength==tempList2.size() )
		{
			//tempList2.add(sum);
			if(!list.contains(tempList2))
				{
					list.add(tempList2);
					//System.out.println(list);
				}
			return list;
		}
		else if (start==a.length)
			return list;
		else if(sum>target)
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
