import java.util.*;
public class simpleGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			int m=sc.nextInt();
			int[] mk=new int[n];
			int[] mkNo=new int[m];
			int[] f1=new int[n];
			int[] g1=new int[n];
			int v1=0;
			
			int[] f2=new int[m];
			int[] g2=new int[m];
			
			for(int i=0;i<n;i++)
				mk[i]=sc.nextInt();
			
			for(int i=0;i<m;i++)
					mkNo[i]=sc.nextInt();
				Arrays.sort(mk);
				Arrays.sort(mkNo);
			
			for(int i=0;i<n;i++){
					f1[i]=0;//strictly smaller
					g1[i]=0;
					int flag=0;
					for(int j=0;j<m;j++){
						if(mk[i]> mkNo[j]){
							f1[i]++;
						}
						if(mk[i]==mkNo[j])
							flag=flag++;
						if(mk[i]< mkNo[j])
							break;
						}
					if(flag!=0)
						g1[i]=m-f1[i]-flag;
					else
						g1[i]=m-f1[i];
						
					v1=v1+(f1[i]*g1[i]);
					
				}
				//System.out.println(v1);
		int v2=0;
					for(int i=0;i<m;i++){
						f2[i]=0;//strictly smaller
						g2[i]=0;
						int flag=0;
						for(int j=0;j<n;j++){
							if(mk[j]< mkNo[i]){
								f2[i]++;
							}if(mk[j]==mkNo[i])
								flag=flag++;
							if(mk[j]> mkNo[i])
								break;
							
						}
						if(flag!=0)
							g2[i]=n-f2[i]-flag;
						else
							g2[i]=n-f2[i];
						
						v2=v2+(f2[i]*g2[i]);
						
					}
				
				//System.out.println(v2);
				
				if(v1>v2)
					System.out.println("Monk "+(v1-v2));
				else if(v2>v1)
					System.out.println("!Monk "+(v2-v1));
				else
					System.out.println("Tie");
				
			
	}

}
