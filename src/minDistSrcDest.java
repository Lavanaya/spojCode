import java.util.LinkedList;
import java.util.Queue;

public class minDistSrcDest {

int xc=3,yc=4;
	static int[][] visited={{Integer.MAX_VALUE,0,Integer.MAX_VALUE,0},
		{0,Integer.MAX_VALUE,0,Integer.MAX_VALUE},
		{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};
	
	public static Queue<Bit> queue=new LinkedList<>();
	static int[][] iterator={{-1,0},{1,0},{0,-1},{0,1}};
	static int[][] m={{3,1,0,3},{3,2,3,0},{0,3,3,0}};
	static int row=3,col=5;
	public static void main(String[] args) {

		Bit bit=new Bit(0,1);
		queue.add(bit);
		bfs();
		System.out.println(visited[1][1]);
	}
	
	public static void bfs(){
		Bit child=null,temp;
		int xc,yc;
		int x,y;
		while(!queue.isEmpty()){
			
			temp=queue.poll();
			x=temp.x;
			
			y=temp.y;
			for(int i=0;i<4;i++) 
			        { 
			            xc=x+iterator[i][0];
			            yc=y+iterator[i][1]; 
			            if(xc>=0 && xc<row && yc>=0 && yc<col && m[xc][yc]!=0 &&visited[xc][yc] > visited[x][y]+1 ) 
			            { 
			                child=new Bit(xc,yc); 
			                        visited[xc][yc]=visited[x][y]+1; 
			                        queue.add(child); 
			            } 
			        } 
		}
	}
	
	/**
	 * class for storing coordinates and its distance from source 
	 * @author lavanya
	 *
	 */
	static class Bit{
	      public int x;
	      public int y;
	      public int distance;
	      
	      public Bit(int x, int y){
	         this.x = x;
	         this.y = y;
	      }
	   }

}
