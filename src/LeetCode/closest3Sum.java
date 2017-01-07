package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class closest3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n={-4,1,2,5};
		int target=1;
		System.out.println(threeSum(n,target));
	}

	public static List<List<Integer>> threeSum(int[] nums,int target) {
		 List<List<Integer>> sums = new ArrayList<List<Integer>>();
		    Arrays.sort(nums);
		    int n = nums.length;
		    for (int i=0; i< n; i++) {
		        if(i>0 && nums[i]==nums[i-1]) continue;
		        int start=i+1; int end=n-1;
		        while(start < end) {

		            if(nums[start] + nums[end] > -nums[i]) {
		                end--;
		            }
		            else if (nums[start] + nums[end] < -nums[i]) {
		                start++;
		            }
		            else {
		                List<Integer> s = new ArrayList<Integer>();
		                s.add(nums[i]);
		                s.add(nums[start++]);
		                s.add(nums[end--]);
		                while(start<end && nums[start]==nums[start-1]) start++;
		                while(start<end && nums[end]==nums[end+1]) end--;
		                sums.add(s);
		            }
		        }
		    }

		     
		    return sums;    
		    }
}
