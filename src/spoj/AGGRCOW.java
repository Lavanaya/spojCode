package spoj;
import java.util.*;

public class AGGRCOW {

	/**
	 * @param args
	 */
	public static int[] a;
	//={1,2,8,4,9};
	public static int cows;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		int t1=0;
		while(t1!=t)
		{
			int stall=sc.nextInt();
			cows=sc.nextInt();

			a=new int[stall];
			for(int i=0;i<stall;i++)
				{
				a[i]=sc.nextInt();
				}
				
			Arrays.sort(a);
		int start=0,end=a[a.length-1]-a[0]+1,mid;
		
	//	System.out.println(a[0]);
	//	System.out.println(a[a.length-1]+"end-star"+(end-start));
		while(end-start>1)
		{
		  mid=(end+start)>>1;
		  if(F(mid)==true)
			  start=mid;
		  else
			  end=mid;
		//  System.out.println("mid: "+mid+" start:"+start+" end: "+end);
		}
		System.out.println(start);
		t1++;
		}
	}
	
	public static  boolean F(int x)
	{
	  //We can always place the first cow in the leftmost stall
	  int cowsplaced=1,lastpos=a[0];
	  for(int i=1;i<a.length;i++)
	  {
	    if(a[i]-lastpos>=x)
	    {
	      //We are at least x away from last placed cow
	      //So we can place one here
	    	cowsplaced++;
	      if(cowsplaced==cows)
	      {	
	    	  return true;
	      }
	      lastpos=a[i];
	    }
	  }
	  return false;
	}


}
