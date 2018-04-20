import java.util.HashSet;

class Solution {
    int longest=0;
    static HashSet<String> set;
    public int longestPalindromeSubseq(String s) {
        set=new HashSet<>();
        longest=0;
        if(s==null) return 0;
        if(s.length()==1)return 1;
        else
            return helper(s,"",0);

    }

    public int helper(String s, String s1, int start){
        // System.out.println(s1+"  "+start);
        //if(start==s.length())
        {
            if(isPalindorminc(s1)&& longest<s1.length()) {
                longest=s1.length();
            }
        }
        {
            for(int i=start;i<s.length();i++){
                if(!s1.isEmpty()||start==0 )
                {
                    //if(memo[i]==0)
                    {
                        if(!set.contains(s1+s.charAt(i)))
                        {
                            set.add(s1+s.charAt(i));
                            helper(s,s1+s.charAt(i),i+1);
                        }
                        if(!set.contains(s1))
                        {
                            set.add(s1);
                            helper(s,s1,i+1);
                        }
                    }
                }
            }
        }
        return longest;
    }

    private boolean isPalindorminc(String s){
        int lef=0,ryt=s.length()-1;
        while(lef<=ryt){
            if(s.charAt(lef)!=s.charAt(ryt))
                return false;
            lef++;ryt--;
        }
        return true;
    }
}