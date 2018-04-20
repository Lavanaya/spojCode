import java.util.*;

class longestPalindromicSubstring{
    static String global="";
   static int start,end;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String a = sc.nextLine();
        for(int i=0;i<a.length();i++)
        {
            longestPalindromicSubString(a,i,i+1); //even
            longestPalindromicSubString(a,i,i); //odd
        }
        System.out.println(global);
        System.out.println(start);
        System.out.println(end);
        String result2="";
        for(int i=a.length()-1;i>end;i--)
            result2+=a.charAt(i);

        result2+=a.substring(0,end+1);

        int length=result2.length()-1-(end-start+1);
        for(int i=length;i>=0;i--)
            result2+=result2.charAt(i);
        System.out.println(result2);

    }

    public  static void longestPalindromicSubString(String s,int st,int e){
        if(st>e) return ;
        if(e>=s.length()|| st<0) return;
        if(s.charAt(st)==s.charAt(e)) {
            if(global.length() < s.substring(st,e+1).length())
            {
                global=s.substring(st,e+1);
                start=st;
                end=e;

            }
            longestPalindromicSubString(s,st-1,e+1);
        }else{

            longestPalindromicSubString(s,st,e+1);
            longestPalindromicSubString(s,st-1,e);
        }
    }
}