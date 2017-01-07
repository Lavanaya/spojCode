package spoj;

import java.util.Scanner;

public class EGYPIZZA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=Integer.parseInt(sc.nextLine());
		//sc.nextLine();
		int result=0;
		int[] f={0,0,0,0};
		for(int i=0;i<t;i++)
		{
			String size=sc.nextLine();
			if(size.trim().equals("1"))
				{
				f[0]++;
				}
			else if(size.trim().equals("3/4"))
			{	++f[1];}
			else if(size.trim().equals("1/2"))
				{++f[2];}
			else if(size.trim().equals("1/4"))
				{++f[3];}	
			
		}
	//	System.out.println(f[2]);
		for(int i=0;i<4;i++)
		{
			switch(i){
			case 0:
				result=result+f[0];
				f[0]=0;
				break;
			case 1:
				while(f[1]!=0 && f[3]!=0){
					result++;
					f[1]--;
					f[3]--;
				}
				if(f[1]!=0)
				{
					result=result+f[1];
				}
				break;
			case 2:
				result=result+(f[2]/2);
				if(f[2]%2!=0 && f[3]!=0){
					result++;
					f[2]=0;
					f[3]--;
				}
				else if (f[2]%2!=0 && f[3]==0){
					result++;f[2]=0;
				}
				break;
				
			case 3:
				result=result+(f[3]/4);
				if(f[3]%4!=0)
					result++;
			}
		}
		System.out.println(result+1);
	}

}
