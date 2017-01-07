package LeetCode;

public class longestPalindromeDp {

	static int[][] table;
	public static void main(String[] args) {
		String str = "aacecaaa";
        table=new int[str.length()+1][str.length()+1];
        for(int i=0;i<str.length();i++)
        	for(int j=0;j<str.length();j++)
        		table[i][j]=0;
        System.out.println(longestPalindrome(str));
	}
	
	public static String longestPalindrome(String s){
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
		System.out.println(maxLength);
		
		return s.substring(start,start+maxLength);
	}

	
}
