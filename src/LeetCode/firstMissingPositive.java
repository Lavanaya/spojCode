package LeetCode;
import java.util.*;
public class firstMissingPositive {

	public static void main(String[] args) {
		int[] a={1,2,0};
	System.out.println(firstMissingPositive(a));
		
	}
//Solution with o(n) space complexity	 
	 public static int firstMissingPositive(int[] nums) {
		 int result=Integer.MAX_VALUE;
		 int flag=0;
		 HashSet<Integer> set=new HashSet<>();
		 for(int i=0;i<nums.length;i++)
			 set.add(nums[i]);
		 for(int i=0;i<nums.length;i++)
		 {
			 if(!set.contains(nums[i]+1))
			 {
				 if(nums[i]>0 && result>nums[i]+1)
					 {
					 	result=nums[i]+1;
					 	flag=1;
					 }
			 }
		 }
		 if(flag==0)
		 return 1;
		 else
			 return result;
	    }

}
