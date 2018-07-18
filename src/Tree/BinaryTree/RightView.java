package Tree.BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    private  static List<Integer> rightView(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        List<Integer> result=new ArrayList<>();
        int countNodes=0;

        queue.add(node);

        while(!queue.isEmpty()){
            countNodes = queue.size();
            int totalNodes=countNodes;
            while (countNodes!=0) {
                TreeNode element = queue.remove();
                if (countNodes == totalNodes) result.add(element.val);

                if (element.right != null) queue.add(element.right);
                if (element.left != null) queue.add(element.left);
                countNodes--;
            }
        }
      return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(10);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        rightView(root).forEach(System.out::println);
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
