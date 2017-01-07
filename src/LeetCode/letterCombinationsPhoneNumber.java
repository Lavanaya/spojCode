package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class letterCombinationsPhoneNumber {
	static String[] a={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	static List<String> result;
	public static void main(String[] args) {
		System.out.println(function("3").toString());
	}

	public static List<String> function(String s){
		result=new ArrayList<String>();
		 function2("",s);
		return result;
		
	}

	public static void function2(String tempResult,String s){
		if(s.length()==0)
			return;
		else if(s.length()==1){
			int index=Integer.parseInt(s);
			char[] c=a[index].toCharArray();
			for(int j=0;j<c.length;j++)
				result.add(tempResult+c[j]);
			return;
		}
		else
		{
			int index=Integer.parseInt(s.charAt(0)+"");
			char[] c=a[index].toCharArray();
			for(int j=0;j<c.length;j++)
				function2(tempResult+c[j],s.substring(1, s.length()));
		}
		}
	}

