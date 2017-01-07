package spoj;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;
import java.util.*;
import java.io.*;


public class MyShop{
	
	private static BufferedReader f;
	static char[] stack=new char[25];
	static int[][] visited=new int[25][25];
	static ArrayList<Integer> result=new ArrayList<>();
	int top=-1;
	static int row=3,col=4,INFINITE=Integer.MAX_VALUE;
	static int[][] grid;
	
	public static void main(String[] args)throws IOException{
		MyShop shop=new MyShop();
		f = new BufferedReader(new InputStreamReader(System.in));
		String[] a=new String[25+4]; //one extra column for \n
		StringTokenizer st;
		boolean findSrc=false;
		int currentX=0,currentY=0;
		
		
		while(true)
		{
			
			try {
			st= new StringTokenizer(f.readLine());
		
			col=parseInt(st.nextToken());
			row=parseInt(st.nextToken());	
			
			if(col==0&&row==0)
					break;
			grid = new int[row][col];
			for(int iteratorRow=0;iteratorRow < row;++iteratorRow)
			{
				a[iteratorRow]=f.readLine();
				{
					for(int i=0;i<a[iteratorRow].length();i++){
						if(a[iteratorRow].charAt(i)=='S')
						{
							currentX=iteratorRow;currentY=i;findSrc=true;
						}
						else if(a[iteratorRow].charAt(i)=='D')continue;
						else if(a[iteratorRow].charAt(i) == 'X')  grid[iteratorRow][i] = INFINITE;
	                    else grid[iteratorRow][i] = a[iteratorRow].charAt(i) - '0'; 
					}
				}
			}
			
			result.add(shop.dijikstra(a, currentX, currentY));
		}
			catch (IOException e) {
				System.out.println("ioException");
				e.printStackTrace();
			}
			
			System.out.flush();
			f.readLine();
			findSrc=false;
	}
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));	
	System.exit(0);
	}
	
	
	//dijikstra
	public int dijikstra (String[] a,int currentX,int currentY){
		
        PriorityQueue<Position> pq;
        boolean[][] visited;
        Position dequeue;
        int x, y, cost, nx, ny;
		 pq = new PriorityQueue<Position>();
         visited = new boolean[row][col];
         
         pq.add(new Position(currentX,currentY,0));
         cost = 0;
         
         while(pq.size() > 0)
         {
             dequeue = pq.poll();
             x = dequeue.x; y = dequeue.y;
             cost = dequeue.cost;
             
             if(a[x].charAt(y)=='D') break;
             if(visited[x][y]) continue;
             visited[x][y] = true;
             
                 nx = x;
                 ny = y-1;
                 if(!(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny] || grid[nx][ny] == INFINITE)) 
                	 pq.add(new Position(nx,ny,cost+grid[nx][ny]));
                 nx = x;
                 ny = y+1;
                 if(!(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny] || grid[nx][ny] == INFINITE)) 
                	 pq.add(new Position(nx,ny,cost+grid[nx][ny]));
                 nx=x-1;
                 ny = y;
                 if(!(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny] || grid[nx][ny] == INFINITE)) 
                	 pq.add(new Position(nx,ny,cost+grid[nx][ny]));
                 nx=x+1;
                 ny = y;
                 if(!(nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny] || grid[nx][ny] == INFINITE)) 
                	 pq.add(new Position(nx,ny,cost+grid[nx][ny]));
                 System.out.println("Next Iteration");
                 Iterator<Position> iter=pq.iterator();
                 while(iter.hasNext()){
                	 System.out.println(iter.next().cost);
                 }
             
         }
        return cost;
	
	}
	
	
	static class Position implements Comparable<Position>
    {
        public int x, y, cost;
        public Position(int x, int y, int cost)
        {
            this.x = x; this.y = y;
            this.cost = cost;
        }
        public int compareTo(Position other)
           {
        	//System.out.println(cost+"  "+other.cost+"\n");
			return cost - other.cost;
        	}
           }
    }

