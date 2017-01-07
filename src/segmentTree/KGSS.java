package segmentTree;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class KGSS {
	
		public static Integer[] array;
		private static PrintWriter out;
		private static Reader in;
	    
		public static class Reader {
		    final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;
		    public Reader(){din=new DataInputStream(System.in);buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
		    }public Reader(String file_name) throws IOException{din=new DataInputStream(new FileInputStream(file_name));buffer=new byte[BUFFER_SIZE];bufferPointer=bytesRead=0;
		    }public String readLine() throws IOException{byte[] buf=new byte[64];int cnt=0,c;while((c=read())!=-1){if(c=='\n')break;buf[cnt++]=(byte)c;}return new String(buf,0,cnt);
		    }public int nextInt() throws IOException{int ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
		    }public long nextLong() throws IOException{long ret=0;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c=read();do{ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(neg)return -ret;return ret;
		    }public double nextDouble() throws IOException{double ret=0,div=1;byte c=read();while(c<=' ')c=read();boolean neg=(c=='-');if(neg)c = read();do {ret=ret*10+c-'0';}while((c=read())>='0'&&c<='9');if(c=='.')while((c=read())>='0'&&c<='9')ret+=(c-'0')/(div*=10);if(neg)return -ret;return ret;
		    }private void fillBuffer() throws IOException{bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);if(bytesRead==-1)buffer[0]=-1;
		    }private byte read() throws IOException{if(bufferPointer==bytesRead)fillBuffer();return buffer[bufferPointer++];
		    }public void close() throws IOException{if(din==null) return;din.close();}
		} 
		public static class SegTree{
			public SegTree Lchild = null, Rchild = null;
			public int leftSum, rightSum, maxSum;
			
			public SegTree(int start,int end){
				if(start==end)
				{
					leftSum = rightSum = maxSum  = array[start];
				}
				else{
					int mid=(start+end)/2;
					 Lchild=new SegTree(start,mid);
					Rchild=new SegTree(mid+1,end);
					join(this,Lchild,Rchild);
				}
			}
			public SegTree() {}
			public void join (SegTree parent, SegTree Lchild, SegTree Rchild) {
	            parent.leftSum = max (Lchild.leftSum, Lchild.rightSum );
	            parent.rightSum = max (Rchild.rightSum, Rchild.leftSum);
	            parent.maxSum = max(max((parent.leftSum +  parent.rightSum),Lchild.maxSum),Rchild.maxSum);
	        }
			
			 public SegTree query (int a, int b,int start,int end) {
		            if (a == start && end == b) return this;
		            int mid = (start + end)>>1;
		          //  System.out.println(mid);
		            if (a > mid) return Rchild.query (a, b,mid+1,end);
		            if (b <= mid) return Lchild.query (a, b,start,mid);
		            SegTree ans = new SegTree ();
		            join (ans, Lchild.query (a, mid,start,mid), Rchild.query (mid + 1, b,mid+1,end));
		            return ans;
		        }
			 public int max(int a,int b){
				 if(a>b)
					 return a;
					 
							 return b;
			 }
			 
			 void update(SegTree node,int start, int end, int idx, int val)
				{
				    if(start == end)
				    {
				        // Leaf node
				    	node.leftSum = node.rightSum = node.maxSum  = val;
				    }
				    else
				    {
				        int mid = (start + end) / 2;
				        if(start <= idx && idx <= mid)
				        {
				            // If idx is in the left child, recurse on the left child
				            update(node.Lchild, start, mid, idx, val);
				            
				        }
				        else
				        {
				            // if idx is in the right child, recurse on the right child
				            update(node.Rchild,mid+1, end, idx, val);
				        }
				        // Internal node will have the sum of both of its children
				        join(node,node.Lchild,node.Rchild);
				    }
				}

		}

		public static void main(String[] args) throws NumberFormatException, IOException {
			StringBuilder sb=new StringBuilder();
			sb=sb.append("");
			in = new Reader ();	
			int n=in.nextInt();
			//String[] temp = br.readLine().split(" ");
			array=new Integer[n+1];
		    for (int i = 1; i <= n; i++) {
	            array [i] = in.nextInt ();
	            }
				// int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    SegTree root = new SegTree (1, array.length-1);
			int m=in.nextInt();
			out = new PrintWriter (System.out, true);
			for(int j=0;j<m;j++){
				int x1=in.nextInt();
				int y1=in.nextInt();
				root.update(root,1,n,1,7);
				sb.append(root.query(x1,y1,1, array.length-1).maxSum+"\n");	   
			}
			out.println(sb);
				}
	}

	
