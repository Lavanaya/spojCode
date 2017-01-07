package spoj;

import java.util.Scanner;

public class MAXLN {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		int t1=0;
		double result;
		while(t1!=t)
		{
			int radius=sc.nextInt();
			result= Math.pow(2*radius, 2);
			result=result+0.25;
			System.out.println("Case "+(t1+1)+": "+ String.format( "%.2f", result ) );
			t1++;
		}

	}

}
