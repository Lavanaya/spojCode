package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/**Kanade algo implementaion
 * Gave TLE
 * See segment tree for 
 **/
 
public class GSS1_Kanade {
	
	
	public static String[] array;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		{
			 array=br.readLine().split(" ");
		}
		
		int m=Integer.parseInt(br.readLine());
		
		//System.out.println(m);
		for(int j=0;j<m;j++){
			String[] index=br.readLine().split(" ");
			int x1=Integer.parseInt(index[0]);
			int y1=Integer.parseInt(index[1]);
			//System.out.println(x1);
			//System.out.println(y1);
			if(x1==y1)
				System.out.println(array[x1-1]);
			else 
				kanadefn(x1,y1);
		}
	}
	
	public static void kanadefn(int x1,int y1){
		BigInteger maxSoFar=new BigInteger(array[x1-1]);
		//System.out.println(maxSoFar);
		BigInteger max_ending_here=new BigInteger(array[x1-1]);
		//System.out.println(max_ending_here);
		BigInteger temp;
		for(int i=x1;i<y1;i++){
			temp=new BigInteger(array[i]);
			max_ending_here=max_ending_here.add(temp);
		//	System.out.println(max_ending_here);
			if(temp.compareTo(max_ending_here)>0)
				max_ending_here=temp;
			if(max_ending_here.compareTo(maxSoFar)>0){
				maxSoFar=max_ending_here;
			}			
		}
		System.out.println(maxSoFar);
	}
}
