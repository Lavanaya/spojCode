package LeetCode;

public class container_with_most_water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height={89,1};
		System.out.println(maxArea(height));
	}
	
public static int maxArea(int[] height) {
	int maxArea=0;
	for(int index=0;index<height.length;index++){
		for(int j=index+1;j<height.length;j++){
			int area=Math.min(height[j],height[index])*(j-index);
			if(maxArea<area)
				maxArea=area;
		}
	}
	return maxArea;
        
    }
}


