import java.util.Arrays;
import java.util.*;


public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		final int[] data = new int[t];
		final Integer[] sorted=new Integer[t];
		for(int i=0;i<t;i++)
			{
			data[i]=sc.nextInt();
			sorted[i]=data[i];
			}
		
		
		Arrays.sort(sorted, new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		    	o1=Math.abs(o1);
		    	o2=Math.abs(o2);
		        return o1.compareTo(o2);
		    }
		});
		for(int i=0;i<t;i++)
		System.out.print(data[i]+" ");

	}

	

	
}
