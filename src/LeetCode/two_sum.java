package LeetCode;

import java.util.*;

public class two_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={-1,-1,-3,-4,-5};
		int[] result=twoSum(nums,-8);
		System.out.println(result[0]+"  "+result[1]);
	}
	
	 public static int[] twoSum(int[] nums, int target) {
	        int[] result=new int[2];
	        int i,j;
	        HashMap<Integer,List<Integer>> inputMap =new HashMap<Integer,List<Integer>>();
	        for(i=0;i<nums.length;i++)
	        {
	             List<Integer> list;
	       
	            if(!inputMap.containsKey(nums[i]))
	                {
	                     list=new ArrayList<>();
	                }
	             else{
	                 list=inputMap.get(nums[i]);
	             }   
	             list.add(i);
	             inputMap.put(nums[i],list);
	           // System.out.println(inputMap.get(nums[i]).toString()+" "+i);
	        }
	        
	        for(j=0;j<nums.length;j++){
	            int req=0;
	            req = target-nums[j];
	         //   if( target== nums[j])
	              {  
	                if(inputMap.containsKey(req)==true && req!=nums[j])
	                {
	                    result[0]=j;
	                    result[1]=inputMap.get(req).get(0);
	                    System.out.print("["+i+", "+inputMap.get(req)+"]");
	                break;
	            }
	            else if(inputMap.containsKey(req)==true && req==nums[j] && inputMap.get(req).size()>1)
	            {
	                    result[0]=j;
	                    result[1]=inputMap.get(req).get(1);
	                    break;
	                
	            }
	        }
	        }
	        return result;        
	    }

}
