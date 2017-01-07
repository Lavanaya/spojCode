package spoj;
import java.math.BigInteger;
import java.util.Scanner;

public class MARBLES {
	static int n,k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    Scanner br=new Scanner(System.in);
		//int t=Integer.parseInt(br.readLine());
		int t=br.nextInt();
		
    while(t!=0)
    {
    	/*String[] input = br.readLine().split(" ");
    	n=Integer.parseInt(input[0]);
    	k=Integer.parseInt(input[1]);
    	*/
    	 n=br.nextInt();
    	 k=br.nextInt();
     	
    	 System.out.println(factorial(n-1,k-1));
    	t--;
    	
    }
  }

	public static BigInteger factorial(int n,int k){
		if(k>n-k) 
			k=n-k;
		BigInteger result1=BigInteger.ONE;
		//Long result1=1L;
	//	if (k < 0 || k > n) return BigInteger.ZERO;
       
		for(int i=0;i<k;i++){
			//result1=(result1*(n-i))/(i);
			
			result1=(result1.multiply(BigInteger.valueOf(n-i))).divide(BigInteger.valueOf(i+1));
		}
		
		//System.out.println("\n\n"+(result1/result2));
	//	return result1.divide(result2);
		return result1;
	}
}
