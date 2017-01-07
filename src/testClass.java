import java.util.Scanner;


public class testClass {

	static int v,c,f,p;
	static int[][] a;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		v=sc.nextInt();
		c=sc.nextInt();
		f=sc.nextInt();
		p=sc.nextInt();
		int n=sc.nextInt();
		a=new int[n][4];
		for(int i=0;i<n;i++){
			a[i][0]=sc.nextInt();
			a[i][1]=sc.nextInt();
			a[i][2]=sc.nextInt();
			a[i][3]=sc.nextInt();
		}
		//System.out.println(a[0][3]);
		boolean flagp=false,flagv=false,flagc=false,flagf=false;
		int flag=0;
		for(int i=0;i<n-1;i++){
			int sum1=0,sum2=0,sum3=0,sum4=0;
			flagp=false;flagv=false;flagc=false;flagf=false;
			for(int j=i+1;j<n;j++){
				
				if(a[i][0]+a[j][0]==v)
					flagv=true;
				else if (a[i][0]+a[j][0]<v)
					//sum1=
				if(a[i][1]+a[j][1]+sum2==c)
					flagc=true;
				if(a[i][2]+a[j][2]+sum3==f)
					flagf=true;
				if(a[i][3]+a[j][3]+sum4==p)
					flagp=true;
				if(flagp && flagv &&flagc && flagf)
				{
					System.out.println("YES");
					flag=1;
					break;
				}
				
				
			}
			if(flag==1)
				break;
		
			//System.out.println("here");
			
		}
		if(!(flagp||flagc||flagf||flagv)){
			System.out.println("NO");
		}
		
	}

}
