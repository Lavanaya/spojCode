package spoj;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AIBOHP {
	 static int[][] L;
	 //	private static Reader sc;
	

	public static void main(String[] args) throws IOException {
	//	Scanner sc=new Scanner(System.in);
		 BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
	     long t=Long.parseLong(sc.readLine());
	//	int t=sc.nextInt();
		//sc.readLine();
		int i=0;
		while(t!=0){
			String s;
			s = sc.readLine();
			L=new int[s.length()+1][s.length()+1];
			for (int k = 0; k < s.length()+1; k++)
		          for (int j = 0; j < s.length()+1; j++)
		             {
		        	  L[k][j] = -1;
		        	  }
			int result=solveLCS(s.length(),s.length(),s,reverse(s));
			//System.out.println(result);
			System.out.println((s.length()-result));

			t--;
		}
	}
	
	public static int solveLCS(int i, int j, String x, String y)
	   {
	      int sol1, sol2, sol3;


	      if (i == 0 || j == 0)
	      {
	         return(0);
	      }

	      if ( L[i][j] >= 0 )
	      {
	         return( L[i][j] );
	      }

	      if ( x.charAt(i-1) == y.charAt(j-1) )
	      {
	         sol1 = solveLCS(i-1, j-1, x, y);

	         L[i][j] = sol1 + 1;
	         return( L[i][j] );
	      }
	      else
	      {
	         sol2 = solveLCS(i-1, j, x, y);
	         sol3 = solveLCS(i, j-1, x, y);

	         L[i][j] = (sol2 >= sol3) ? sol2 : sol3;

	         return( L[i][j] );
	      }
	     }
	public static String reverse(String s){
		char[] c=s.toCharArray();
		String sRev="";
		//System.out.println(c.length-1);
		for(int i=c.length-1;i>=0;i--)
		{
			sRev=sRev+c[i];
		}
		return sRev;
	}
	
	  static class Parser {
	        final private int BUFFER_SIZE = 1 << 16;  // 2^16, a good compromise for some problems
	        private InputStream din;    // Underlying input stream
	        private byte[] buffer;      // Self-maintained buffer
	        private int bufferPointer;  // Current read position in the buffer
	        private int bytesRead;      // Effective bytes in the buffer read from the input stream

	        public Parser(InputStream in) {
	            din = in;
	            buffer = new byte[BUFFER_SIZE];
	            bufferPointer = bytesRead = 0;
	        }

	        /**
	         * Read the next integer from the input stream.
	         * @return The next integer.
	         * @throws java.io.IOException
	         */
	        public int nextInt() throws IOException {
	            int result = 0;
	            byte c = read();
	            while (c <= ' ') c = read();
	            boolean neg = (c == '-');
	            if (neg) c = read();
	            while (c >= '0' && c <= '9') {
	                result = result * 10 + c - '0';
	                c = read();
	            }
	            if (neg) return -result;
	            return result;
	        }

	        /**
	         * Read a line of data from the input stream.
	         * @return the next line of data.
	         * @throws IOException if an I/O error occurs.
	         */
	        public String readLine() throws IOException {
	            StringBuilder line = new StringBuilder();
	            char c;
	            while ((c = (char)(read())) != '\n') {
	                line.append(c);
	            }
	            return line.toString();
	        }

	        /**
	         * Read the next byte of data from the input stream.
	         * @return the next byte of data, or -1 if the end of the stream is reached.
	         * @throws IOException if an I/O error occurs.
	         */
	        public byte read() throws IOException {
	            if (bufferPointer == bytesRead)
	                fillBuffer();
	            return buffer[bufferPointer++];
	        }

	        /**
	         * Read data from the input stream into the buffer
	         * @throws IOException if an I/O error occurs.
	         */
	        private void fillBuffer() throws IOException {
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	            if (bytesRead == -1)
	                buffer[0] = -1;
	        }
	    }

}
