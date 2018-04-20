import java.util.*;

public class topViewBT {

    /**
     * Time complexity O(n) space 2n
     * improvement maintain a pair as value in map rather than creating two maps to obtain n space complexity
     *
     * For bottom view: change (int)map.get(level) > horLevel to (int)map.get(level) < horLevel
     * @param args
     */

    public static void main(String[] args)
    {
        /* Create following Binary Tree
             1
           /  \
          2    3
         / \
        7   4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        topViewBT t = new topViewBT();
        System.out.println("Following are nodes in top view of Binary Tree");
        HashMap<Integer,Integer> map=t.printTopView(root,0, new HashMap<Integer,Integer>(),0,new HashMap<Integer,Integer>());

        Set<Map.Entry<Integer,Integer>> it=map.entrySet();
        for(Map.Entry<Integer,Integer> entry:it){
            System.out.println(entry.getValue());
        }


    }

    public HashMap printTopView(TreeNode root, int level, HashMap map,int horLevel,HashMap result){
        if(root==null) return result;
        else{

            if(!map.containsKey(level)|| (int)map.get(level) > horLevel) {result.put(level,root.key);map.put(level,horLevel);}
            printTopView(root.left,level-1, map,horLevel+1,result);
            printTopView(root.right,level+1, map,horLevel+1,result);
            return result;
        }
    }
}


class TreeNode
{
    // Members
    int key;
    TreeNode left, right;

    // Constructor
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}
