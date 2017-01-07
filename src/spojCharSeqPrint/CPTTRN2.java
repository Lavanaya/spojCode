package spojCharSeqPrint;

import java.util.Scanner;

public class CPTTRN2 {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int [][] a=new int[t+1][3];
		//take inputs
		for(int i=0;i<t;i++)
			{
				a[i][0]=sc.nextInt();
				a[i][1]=sc.nextInt();
			}
		//initailize array outer boundary with *
		int i=0;
		while(t!=0)
		{
			if(a[i][0]==2)
			{
				for(int j=0;j<a[i][1];j++)
					System.out.print("*");
				System.out.println("\n");
				for(int j=0;j<a[i][1];j++)
					System.out.print("*");
			}
			for(int k=0;k<a[i][0];k++)
			{
				if(k==0||k==a[i][0]-1)
				{
					for(int j=0;j<a[i][1];j++)
						System.out.print("*");
					System.out.println("\n");
				}else
				{
					
				}
			}
			
			t--;
		}
		
	} 

}
