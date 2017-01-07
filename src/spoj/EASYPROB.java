package spoj;

import java.io.IOException;
import java.util.*;

public class EASYPROB {

	public static void main(String args[]) throws IOException {
		Integer[] input={137, 1315, 73, 136, 255, 1384, 16385}; 	
		for(int i =0;i<7;i++){
			System.out.print(input[i]+"=");
			patternPrint(input[i]);
			System.out.println();
		}
	}	
	
	private static void patternPrint(int n){
		int N=n;
	    if(n<=3){
	        if(n==3) System.out.print("2+2(0)");
	        else if(n==2) System.out.print("2");
	        else if(n==1) System.out.print("2(0)");
	        else System.out.print("ERROR");
	        return;
	    }
	    int j=0;
	    while(n>0){
	        j++;
	        n=n/2;
	    }
	    int a=(int) Math.pow((double)2,(double)j-1);
	    System.out.print("2(");
	    patternPrint(j-1);
	    System.out.print(")");
	    if(N-a!=0) {System.out.print("+");patternPrint(N-a);}
		
	}
}
