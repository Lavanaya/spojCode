package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BITMAP {
	public static int[][] arr,visitied;
	public static Queue<Bit> queue=new LinkedList<>();
	static int[][] iterator={{-1,0},{1,0},{0,-1},{0,1}};
	static int row=0,col=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t!=0){
			st= new StringTokenizer(br.readLine());
			row=Integer.parseInt(st.nextToken());
			col=Integer.parseInt(st.nextToken());
			arr=new int[row+1][col+1];
			visitied=new int[row+1][col+1];
			for(int i=0;i<row;i++)
			{	
				char[] c= br.readLine().trim().toCharArray();
				//System.out.println(c[2]+"   "+c.length);
				for(int j=0;j<col;j++)
				{
					arr[i][j]=c[j]-'0';
				}
			}
			Bit bit = null;
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<col;j++)
				{
					if(arr[i][j]==0)
						arr[i][j]=Integer.MAX_VALUE;
					else
					{
						arr[i][j]=0;
						bit=new Bit(i,j);
						queue.add(bit);
					}
				}
			}
			br.readLine();
			bfs();
			t--;
			for(int i=0;i<row;i++)
			{		for(int j=0;j<col;j++)
					System.out.print(arr[i][j]+" ");
			System.out.println();
			}
			
		}
					
	}
		
	static class Bit{
	      public int x;
	      public int y;
	      public int distance;
	      
	      public Bit(int x, int y){
	         this.x = x;
	         this.y = y;
	      }
	   }
	
	public static void bfs(){
		Bit temp,front,child;
		int x,y,xc,yc;
		while(!queue.isEmpty()) 
	    { 
	        temp=queue.poll(); 
	        //queue.pop(); 
	        x=temp.x;
	        y=temp.y; 
	        for(int i=0;i<4;i++) 
	        { 
	            xc=x+iterator[i][0];
	            yc=y+iterator[i][1]; 
	            if(xc>=0 && xc<row && yc>=0 && yc<col && arr[xc][yc]>arr[x][y]+1) 
	            { 
	                child=new Bit(xc,yc); 
	                        arr[xc][yc]=arr[x][y]+1; 
	                        queue.add(child); 
	            } 
	        } 
	    } 
			
		}
	}



