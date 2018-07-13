/*
import javax.swing.tree.TreeNode;
import java.util.concurrent.BlockingQueue;

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *//*


 class KnapSack {

     BlockingQueue
    private TreeNode lca;
    boolean fa=false,fb=false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        TreeNode node = dfs(root, p, q);
        if(node!=null && fa && fb) return node;
        return node;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {

        if(node == null) {
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode  right = dfs(node.right, p, q);

        if(node==p){
            fa=true;
            return node;
        }
        else if(node==q){
            fb=true;
            return node;
        }
        else if(left!=null && right!=null) return node;

        return left!=null?left:right;
    }
}*/
