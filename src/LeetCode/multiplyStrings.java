package LeetCode;

import java.util.*;
public class multiplyStrings {
    public String multiply(String num1, String num2) {
        int carry=0,i=0,j=0;
        StringBuilder st=new StringBuilder();
        for( i=num1.length()-1, j=num2.length()-1;i>-1 && j>-1;i--,j--){
            int product = ((int)(num1.charAt(i)-'0') * (int)(num1.charAt(i)-'0'))+carry;
            st.insert(0, (Integer.toString(product%10)));
            System.out.println(st);
            carry=product/10;
        }
        System.out.println(st);
        if(i>-1){
            while(i>-1){
                int product = Character.getNumericValue(num1.charAt(i))+carry ;
                st.insert(0, (Integer.toString(product%10)));
                carry=product/10;
                i--;
            }
        }else if(j>-1){
            while(j>-1){
                int product = Character.getNumericValue(num2.charAt(j))+carry ;
                st.insert(0, (Integer.toString(product%10)));
                carry=product/10;
                j--;
            }
        }
        //String s=st;
        
        return st.toString();
    }
}