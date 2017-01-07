package spoj;
import java.util.*;
public class ANARC09A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int j=1;
		while(true){
		String s=sc.next();
		if(s.contains("-"))
			break;
		System.out.println(j+". "+balance(s));
		j++;
		}
	}

	
	public static int balance(String s){
		int bal=0,result=0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='{')
				bal++;
			else 
				bal--;
			
			if(bal<0)
			{
				result++;
				bal+=2;
			}
		}
		//System.out.println("result="+result);
		//System.out.println("bal="+bal);
		if(bal>0)
		{
			result=result+bal/2;
			//System.out.println(result);
		}else if(bal<0)
		{
			result=result + bal/2;
		}
		return result;
		
	}
}
