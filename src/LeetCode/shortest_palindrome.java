package LeetCode;

public class shortest_palindrome {
	static int[][] table;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "";
        table=new int[str.length()+1][str.length()+1];
        for(int i=0;i<str.length();i++)
        	for(int j=0;j<str.length();j++)
        		table[i][j]=0;
        System.out.println(longestPalindrome(str));
	}
	
		static public String intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if(left==-1)
		return s.substring(left + 1, right);
		else 
			return null;
	}
   public static String longestPalindrome(String s) {
		int n=s.length();
		
       if (s == null) return null;
       else if(s.isEmpty())
       return s;
		String longest = s.substring(0, 1);
		for (int i = s.length()/2 ; i > -1; i--) {
			//odd cases like 121
			String palindrome = intermediatePalindrome(s, i, i);
			
			if (palindrome!=null && palindrome.length() > longest.length()) {
				longest = palindrome;
				
			}
			//even cases like 1221
		//		System.out.println("here"+i);
			palindrome = intermediatePalindrome(s, i, i + 1);
			if (palindrome!=null && palindrome.length() > longest.length()) {
			    longest = palindrome;
                break;
			}
		}
		
		int maxLength=longest.length();
	//	System.out.println(maxLength);
		if(maxLength==1){
			String s2=s.substring(1, s.length());
			String s3="";
			for(int j=s2.length()-1;j>=0;j--)
				s3=s3+s2.charAt(j);
			return(s3+s);}
		else if (maxLength!=n)
		{
			String s2=s.substring(maxLength,n);
			String s3="";
			for(int j=s2.length()-1;j>=0;j--)
				s3=s3+s2.charAt(j);
			return((s3+s));
		}
		
		return longest;
	
   }	
/*	public static String longestPalindrome(String s){
		if(s.isEmpty())
			return s;
		  if (s == null) return null;
			String longest = s.substring(0, 1);
		String longestPalindromicString="";
		int n=s.length();
		int maxLength = 1;
	    for (int i = 0; i < n; ++i)
	        table[i][i] = 1;
	 
	    // check for sub-string of length 2.
	    int start = 0;
	    for (int i = 0; i < n-1; ++i)
	    {
	        if (s.charAt(i) == s.charAt(i+1))
	        {
	            table[i][i+1] = 1;
	            start = i;
	            maxLength = 2;
	        }
	    }
	    for(int k=3;k<=n;k++){
			for(int i=0;n-k-i>-1;i++){
				int j = i + k - 1;
				//System.out.println(j);
				if(table[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)){
					if(k>maxLength){
					maxLength=k;
					start=i;
					}
					table[i][j]=1;
				}
			}
		}
		
	    start = 0;
	    maxLength=1;
	    for (int i = 0; i <1&&i<n-1; ++i)
	    {
	        if (s.charAt(i) == s.charAt(i+1))
	        {
	            table[i][i+1] = 1;
	            start = i;
	            maxLength = 2;
	        }
	    }
	    for(int k=3;k<=n;k++)
	    {
	    	int j=0+k-1;
	    	if(table[0+1][j-1]==1 && s.charAt(0)==s.charAt(j)){
				if(k>maxLength){
				maxLength=k;
				start=0;
				}
				table[0][j]=1;
			}
	    }
		System.out.println(maxLength);
		
		if(maxLength==1){
			String s2=s.substring(1, s.length());
			String s3="";
			for(int j=s2.length()-1;j>=0;j--)
				s3=s3+s2.charAt(j);
			return(s3+s);}
		else if (maxLength!=n)
		{
			String s2=s.substring(maxLength,n);
			String s3="";
			for(int j=s2.length()-1;j>=0;j--)
				s3=s3+s2.charAt(j);
			return((s3+s));
		}
		//System.out.println(maxLength);
		
		return s.substring(start,start+maxLength);
	}
*/
}
