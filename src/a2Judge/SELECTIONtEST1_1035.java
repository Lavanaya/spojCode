package a2Judge;

import java.util.Scanner;

public class SELECTIONtEST1_1035 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[] s= sc.nextLine().split(" ");
		
		int a=Integer.parseInt(s[0]);
		int b=Integer.parseInt(s[1]);
		int c=Integer.parseInt(s[2]);
		int d=Integer.parseInt(s[3]);
		
		if(b>c && d>a && c+d>a+b && c>-1 && d>-1 && a%2==0)
			System.out.println("Valores aceitos");
			
			else		System.out.println("Valores nao aceitos");
			
		
			
	}

}
