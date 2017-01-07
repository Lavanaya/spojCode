package LeetCode;

public class next_permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] nums={1,3,2};
	nextPermutation(nums);
	}
	
	public static void nextPermutation(int[] nums) {
		if(nums.length==1)
			return;
		int i=0,flag=0,j=0;
		int len=nums.length;

		
		for(i=len-1;i>0;i--){
			if(nums[i]<=nums[i-1])
			{	System.out.println("i="+i);
				continue;}
			else if (nums[i]>nums[i-1])
			{
				j=i-1;
				for(int k=len-1;k>i-1;k--){
					if(nums[i-1]<nums[k])
					{
						swap(nums,i-1,k);
						flag=1;
						break;
					}
				}
			}
			if(flag==1)
				break;
		}
		if(flag==0)
			j=-1;
		
		/*for(i=len-1;i>0;i--){
			for( j=i-1;j>=0;j--){
				if(nums[i]>nums[j]){
					swap(nums,i,j);
					flag=1;
					break;
					}
			}
			if(flag==1)
				break;
		}*/
		
		for( j=j+1;j<len-1;j++){
			for(int k=j+1;k<len;k++)
			{
				if(nums[j]>nums[k])
					swap(nums,j,k);
				
			}
		}
		for(i=0;i<len;i++)
			System.out.print(nums[i]);
    }
	
	public static void swap(int[] nums,int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
		return;
	}

}
