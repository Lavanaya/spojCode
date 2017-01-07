package spoj;
import java.util.*;

public class MIXTURES {
	
	static int[][] dp;
static int i=0;
	public static void main(String[] args) {
		
		List<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		dp=new int[list.size()][list.size()];
		/*for(int i=)
		*/System.out.println(fn(0,list,0));	
	}
	
	public static  int fn(int start,List<Integer> list,int smoke){
		if(list.size()==2)
		return list.get(0)*list.get(1);
		
		else if(list.size()<2||start==list.size()-1)
			return smoke;
		else{
			
			//	System.out.println(list.size());
				List<Integer> temp=new ArrayList<>();
				temp.addAll(list);
				int smoke1 = temp.get(start)*temp.get(start+1);
				temp.add(start,(temp.get(start)+temp.get(start+1))%100);
				
				temp.remove(start+1);
				temp.remove(start+1);
				//System.out.println(temp.size());
				
				smoke1=fn(start,temp,smoke1+smoke)+smoke1;
				System.out.println("smoke1  "+smoke1+"\n");
				
				/*List<Integer> temp2=new ArrayList<>();
				temp2.addAll(list);
				*//*int smoke2 = temp2.get(start)*temp2.get(start+1);
				temp.add(start+1,(temp.get(start)+temp.get(start+1))%100);
				
				temp.remove(start+1);
				temp.remove(start+1);
				*/
				int smoke2=Integer.MAX_VALUE;
				if(start+1<list.size()-1)
					smoke2=fn(start+1,list,smoke);
				System.out.println("smoke2   "+smoke2+"\n");
				smoke= Math.min(smoke1, smoke2)+smoke;
				
			
		}
		return smoke;
	}

}
