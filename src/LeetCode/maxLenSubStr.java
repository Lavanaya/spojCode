package LeetCode;

import java.util.*;

//Accepted solution

public class maxLenSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	//	String s=sc.nextLine();
		String s="aacd";
	//	String s="cdascde";
		char[] c=s.toCharArray();
		String max_result="";
		String result="";
		HashMap<String,Integer> map=new HashMap<>();
		if(s.length()>0)
		{String temp = String.valueOf(c[0]);
		map.put(temp, 0);
		result=result+String.valueOf(c[0]);
		}
		for(int i=0;i<c.length;i++){
			for(int j=i+1;j<c.length;j++)
			{	String temp2 =String.valueOf(c[j]);
				if(!map.containsKey(String.valueOf(c[j])))
				{
					map.put(temp2, j);
					result=result+c[j];	
				}
				else
				{	
					result=	result.substring(result.indexOf(temp2)+1,result.length());
					map.put(temp2, j);
					result=result+c[j];	
					i = j-1;
					break;
				}
				if(max_result.length()<result.length())
					max_result=result;
			}
			if(max_result.length()<result.length())
				max_result=result;
		}
		System.out.println(max_result.length());

	}

}
