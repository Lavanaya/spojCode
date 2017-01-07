package spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AMR10G {

	public static void main(String[] args) {
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner Input = new Scanner(System.in);
		ArrayList<Integer> array;
		int n,k,minDif=Integer.MAX_VALUE;
		int t = Input.nextInt();
		//StringTokenizer st;
		while(t!=0){
			n = Input.nextInt();
			k = Input.nextInt();
			array=new ArrayList<>();
			for(int i=0;i<n;i++){
				array.add(Input.nextInt());
			}
			Collections.sort(array);
		//	System.out.println("Here:"+array.toString()+"\n");
			for(int i=0;i<=n-k;i++)
			{
				//System.out.println("k:"+k+" n:"+n+"\n");
				if(i+k-1 < n){
					int diff=array.get(i+k-1)-array.get(i);
					//System.out.println("\ndiff is:"+diff+"\n");
					if(minDif > diff)
						minDif = diff;
				}
				else
					break;
			}
			System.out.println(minDif);
			t--;
			minDif=Integer.MAX_VALUE;
		}
			
	}

}
