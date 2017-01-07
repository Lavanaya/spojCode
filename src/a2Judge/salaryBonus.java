package a2Judge;

import java.util.Scanner;

public class salaryBonus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Double a=sc.nextDouble();
		Double b=sc.nextDouble();
		Double ans=a+((b*3)/20);
		System.out.println("Total = R$ "+ans);
	}

}
