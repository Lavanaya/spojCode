package Tree.BinaryTree;

public class LCA {

    private static boolean fa,fb;

    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node result=lca(root,root.left,root.left.right);

        if(result!=null && fa&&fb) System.out.println(result.data);
       /* System.out.println("LCA(4, 5): " + lca(root,4,5));
        System.out.println("LCA(4, 6): " + findLCA(4,6));
        System.out.println("LCA(3, 4): " + findLCA(3,4));
        System.out.println("LCA(2, 4): " + findLCA(2,4));*/

    }
    private static Node lca(Node n,Node a, Node b){
        if(n==null) return n;
        Node left=lca(n.left,a,b);
        Node right=lca(n.right,a,b);

        if(a==n){fa=true;return n;}
        else if(b==n){fb=true;return n;}

         else
             if(left!=null&&right!=null) return n;

        return left!=null?left:right;

    }
}
