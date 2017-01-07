import java.util.*;
public class LongestIncreasing {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int flag = 0;
	    int maxLenSubarray =0;
	    int maxStart=0,maxEnd=0,start=0,end=0;
	    for(int i=1;i<n;i++){
	        if(a[i-1]<=a[i]){
	            if(flag!=1){
	                start = i-1;
	                flag=1;
	            }
	            if(i == n-1){
	                end = n-1;
	            }
	        }
	        else{
	            if(flag==1 ){
	                end = i-1;
	                flag =0;
	            }
	        }
	        if(maxLenSubarray < end - start){
	        	maxLenSubarray = end - start;
	            maxStart = start;
	            maxEnd = end;
	        }
	    }

	    System.out.println(maxLenSubarray+1);
	 //   System.out.println("Starting index = "+maxStart+" Ending index = "+maxEnd); 
	}

}
