package spoj;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.util.*;
import java.io.*;
public class netShopSol{
	private static BufferedReader f;
	static char[] stack=new char[25];
	static int[][] visited=new int[25][25];
	static ArrayList<Integer> result=new ArrayList<>();
	int top=-1;
	static int row=3,col=4,minDistance=Integer.MAX_VALUE;
	public static void main(String[] args)throws IOException{
		netShopSol shop=new netShopSol();
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
			/*	col=sc.nextInt();
				row=sc.nextInt();
			*/	if(col==0&&row==0)
					break;
			//	sc.skip("[\n]+");
			for(int iteratorRow=0;iteratorRow < row;++iteratorRow)
			{
				a[iteratorRow]=f.readLine();
				if(!findSrc){
						for(int i=0;i<a[iteratorRow].length();i++){
								if(a[iteratorRow].charAt(i)=='S')
									{
									currentX=iteratorRow;currentY=i;findSrc=true;
									}
							}
				}
				//[iteratorRow]=sc.next();	
			}
			
		
			result.add(shop.findShortesPath(a, currentX, currentY));
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
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
	public int findShortesPath(String[] a,int currentX,int currentY){
		a[currentX]=a[currentX].replace("S", "0");
		try{
		int distance = dijikstra(a,currentX,currentY);
		
		return distance;}catch(Exception ex){
			System.out.println("dijikstra exception");
		}
		return 0;
	}
	//find source position
	public int[] findSrcPosition(String[] a){
		int[] indices=new int[3];
		boolean sourceFound=false;
		for(int index=0;index < a.length;++index){
			if(a[index].contains(String.valueOf('S'))){
				for(int i=0;i<a[index].length();i++){
					if(a[index].charAt(i)=='S')
						{indices[0]=index;indices[1]=i;sourceFound=true;break;}
				}
			}
			if(sourceFound==true)
				break;
			}
		return indices;
	}
	
	//dijikstra
	public int dijikstra (String[] a,int currentX,int currentY){
		try{
			
		int right=Integer.MAX_VALUE-100,left=Integer.MAX_VALUE,up=Integer.MAX_VALUE,down=Integer.MAX_VALUE;
		if(currentX==row||currentX==-1||currentY==-1||currentY==col)
			return right;
		if(a[currentX].charAt(currentY)=='X')
			return right;
		if(a[currentX].charAt(currentY)=='D')
			return 0;
	//	System.out.println(a[currentX].charAt(currentY)-'0');
		visited[currentX][currentY]=1000;
		
		if(!(currentX==row||visited[currentX+1][currentY]==1000)) //if already visited return
			{
				right=dijikstra(a, currentX+1, currentY)+(int)(a[currentX].charAt(currentY)-'0');
			}else if(currentX!=row && visited[currentX+1][currentY]!=1000 && visited[currentX+1][currentY]!=0)
				right=visited[currentX+1][currentY]+(int)(a[currentX].charAt(currentY)-'0');
		
		if(!(currentX==0 || visited[currentX-1][currentY]==1000))
			left=dijikstra(a, currentX-1, currentY)+(int)(a[currentX].charAt(currentY)-'0');
		else if(currentX!=0 && visited[currentX-1][currentY]!=1000 && visited[currentX-1][currentY]!=0)
			left=visited[currentX-1][currentY]+(int)(a[currentX].charAt(currentY)-'0');
	
		if(!(currentY==col || visited[currentX][currentY+1]==1000))
			down=dijikstra(a, currentX, currentY+1)+(int)(a[currentX].charAt(currentY)-'0');
		else if(currentY!=col && visited[currentX][currentY+1]!=1000 && visited[currentX][currentY+1]!=0)
			down=visited[currentX][currentY+1]+(int)(a[currentX].charAt(currentY)-'0');
	
		if(!(currentY==0 ||visited[currentX][currentY-1]==1000))
			up=dijikstra(a, currentX, currentY-1)+(int)(a[currentX].charAt(currentY)-'0');
		else if(currentY!=0 && visited[currentX][currentY-1]!=1000 && visited[currentX][currentY-1]!=0)
			up=visited[currentX][currentY-1]+(int)(a[currentX].charAt(currentY)-'0');
	
		
		int min= right<left?(right<up?(right<down?right:down):(up < down?up:down)): (left<up?(left<down?left:down):(up < down?up:down));
		visited[currentX][currentY]=min;
		return min;
	}catch(Exception ex){
		System.out.println("dijikstra error");
	}finally{
		//System.err.println("existing system");
	}
	return 0;
	}
}
