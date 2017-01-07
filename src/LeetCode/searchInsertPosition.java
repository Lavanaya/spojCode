package LeetCode;

public class searchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1};
		System.out.println(searchInsert(a,2));
		System.out.println(searchInsert(a,7));
		System.out.println(searchInsert(a,0));
		System.out.println(searchInsert(a,1));
		System.out.println(searchInsert(a,8));
	}
	 public static int searchInsert(int[] nums, int target) {
	        int start=0,end=nums.length-1;
	        int result=0;
	        while(start<=end){
	        	
	        	int mid=(start+end)/2;
	        	//System.out.println(mid);
	        	if(nums[mid]==target)
	        		return mid;
	        	
	        	else if(nums[mid]<target)
		        	start=mid+1;
	        	else if(nums[mid]>target)
	        		end=mid-1;
	        }
	        if(start==0)
	        	return 0;
	        else if(end==nums.length-1)
	        	return end;
	        return start;
	    }

}
