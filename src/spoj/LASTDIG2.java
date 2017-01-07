package spoj;
//import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

public class LASTDIG2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	//	StringTokenizer st;
		int q[][]={{},{},{6,2,4,8},{1,3,9,7},{6,4,6,4},{},{},{1,7,9,3},{6,8,4,2},{1,9,1,9}},m,t1=0,ans,t;
		t=parseInt(bf.readLine());
		while(t1<t){
			String[] s=bf.readLine().split(" ");
			char[] a=s[0].toCharArray();
			long b = Long.parseLong(s[1]);
			int l=a[a.length-1]-'0';
			  if(b==0){ans=1;}else if(l==0||l==1||l==6||l==5){ans=l;}else{ m=(int)(b%4);ans=q[l][m];}
			System.out.println(ans);
			t1++;
		}
	}

}
