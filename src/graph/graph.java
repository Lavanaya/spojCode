package graph;

import java.util.LinkedList;

public class graph {
    int V;
    LinkedList<Integer> adj[];
    public graph(int v){
        this.V=v;
        adj=new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
    }

}
