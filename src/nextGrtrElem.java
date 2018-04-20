import java.util.Stack;

public class nextGrtrElem {

    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        int[] a={4,5,2,25};
        int[] next=new int[a.length+1];
        int i=a.length-1;
        st.push(a[i]);
        next[i]=-1;

        while(i>-1){
            while(!st.isEmpty() && a[i]>st.peek()){
                st.pop();
            }

            if(!st.isEmpty()&& a[i]<st.peek())
                next[i]=st.peek();
            else
                next[i]=-1;
            st.push(a[i]);
            i--;
        }

        for(i=0; i<a.length;i++) System.out.println(next[i]);

    }


}
