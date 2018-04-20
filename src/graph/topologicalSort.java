package graph;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class topologicalSort {

    public static void main(String args[])
    {
        graph  g = new graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        topologicalSort ts=new topologicalSort();
        ts.dfs(0,g);

    }

    public void dfs(int start,graph G){
        boolean[] visited=new boolean[G.V];
        Stack<Integer> st= new Stack<Integer>();
        for(int i=0;i<G.V;i++)
            visited[i]=false;
        for(int i=0;i<G.V;i++)
            if(!visited[i])
            topo(i,st,visited,G);

        // Print contents of stack
        while (st.empty()==false)
            System.out.print(st.pop() + " ");
    }
    public void topo(int s,Stack st,boolean[] visited,graph G){
        visited[s]=true;
        Iterator<Integer> it=G.adj[s].iterator();
        while (it.hasNext()){
            int u=it.next();
            if(!visited[u])
                topo(u,st,visited,G);
        }
        st.push(new Integer(s));
    }
}
