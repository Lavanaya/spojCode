package spoj;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/**
 * 
 * @author lavanya
 *coin hashmap question
 */
public class NY10A {
	private static BufferedReader f;
	
	public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	//f = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	//st= new StringTokenizer(f.readLine());
	//st= new StringTokenizer(f.readLine());
	
	
	int t=sc.nextInt();
	//int t=parseInt(st.nextToken());
	int t1=0;
	HashMap<String,Integer> output=new HashMap<String,Integer>();
	
	while(t1<t){
		//st= new StringTokenizer(f.readLine());
		
		//int number=parseInt(st.nextToken());
		int number=sc.nextInt();
		sc.nextLine();
	
		String s=sc.nextLine();
		
		output.put("TTT",0);
		output.put("TTH",0);
		output.put("THT",0);
		output.put("THH",0);
		output.put("HTT",0);
		output.put("HTH",0);
		output.put("HHT",0);
		output.put("HHH",0);
			
		for(int i=0;i<s.length()-2;i++){
			
			String subStr=s.substring(i, i+3);
			int occurence=output.get(subStr);
			output.put(subStr,occurence+1);
		}
		System.out.println(t1+1+" "+output.get("TTT")+" "+output.get("TTH")+" "+output.get("THT")+" "+output.get("THH")+" "+output.get("HTT")+" "+output.get("HTH")+" "+output.get("HHT")+" "+output.get("HHH"));
		t1++;
	//	System.out.flush();
	//	f.readLine();
		
	}
	}

}
