package segmentTree;

public class sumInRange {
	static Integer[] tree=new Integer[14];
	static Integer[] input={0,-1,2,4,6,-5};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		buildSegTree(1,1,5);
		sumInRange object=new sumInRange();
		int a=object.query(1,1,5,1,3);
		System.out.println(a);
}
	
	public static void buildSegTree(int node, int start, int end){
		if(start==end)
			 tree[node]=input[start];
		else{
			int mid=(start+end)/2;
			// Recurse on the left child
			buildSegTree(2*node, start, mid);
	        // Recurse on the right child
			buildSegTree(2*node+1, mid+1, end);
	        // Internal node will have the sum of both of its children
	        tree[node] = tree[2*node] + tree[2*node+1];
	        System.out.println(tree[node]+"  node"+node);
		}
	}
	
	public int query(int node, int start, int end, int l, int r)
	{
	    if(r < start || end < l)
	    {
	        // range represented by a node is completely outside the given range
	        return 0;
	    }
	    if(l <= start && end <= r)
	    {
	        // range represented by a node is completely inside the given range
	        return tree[node];
	    }
	    // range represented by a node is partially inside and partially outside the given range
	    int mid = (start + end) / 2;
	    int p1 = query(2*node, start, mid, l, r);
	    int p2 = query(2*node+1, mid+1, end, l, r);
	    return (p1 + p2);
	}
	/*public void printTreeBSF(){
		heightTree();
		
	}
	public int height(int index){
		if()
		int left=height(left);
		int right=height(right);
	}*/

}
