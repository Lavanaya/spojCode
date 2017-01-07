package LeetCode;

public class bitwiseAndOfNumbersRange {

	public static void main(String[] args) {
		rangeBitwiseAnd(0,234567);

	}
	public static int rangeBitwiseAnd(int m, int n) {
	    if(n==0||m==0)
	        return 0;
	     for(int i=n-1;i>=m;i--){
	         n=n&i;
	         i=n;
	         if(n==0)
	         break;
	     }
	     return n; 
	     }
	
	

}
