package a2Judge;

import java.util.*;
public class chess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			
			int l=Integer.parseInt(sc.nextLine());
			String s=sc.nextLine();
			int anton=0,danik=0;
			for(int i=0;i<l;i++)
			{
				if(s.charAt(i)=='A')
					anton++;
				else
					danik++;
			}
			if(anton>danik)
				System.out.println("Anton");
			else  if(anton<danik)
				System.out.println("Danik");
			else
				System.out.println("Friendship");
	}
	

}
