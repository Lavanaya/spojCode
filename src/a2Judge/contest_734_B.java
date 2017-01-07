package a2Judge;
import java.util.*;
public class contest_734_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k2=sc.nextInt();
		int k3=sc.nextInt();
		int k5=sc.nextInt();
		int k6=sc.nextInt();
		
		int n256=0,n32=0;
		while(true){
			if(k2<1 || k5<1 || k6<1)
				break;
				else{
					k2--;k5--;k6--;
					n256++;
				}
		}
		
		while(true){
			if(k2<1 || k3<1 )
				break;
				else{
					k2--;k3--;
					n32++;
				}
		}
		long result=n256*256 + n32*32;
		
		System.out.println(result );
		
		
	}

}
