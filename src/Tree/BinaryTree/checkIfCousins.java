package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class checkIfCousins {


    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(15);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        checkIfCousins c = new checkIfCousins();
        System.out.println(c.isCousins(root, 5, 20));
    }

    boolean isCousins(Node n, int a, int b) {
        if (n == null) return false;
        Queue<Node> q = new LinkedList<Node>();
        q.add(n);
        //  int size = q.size();
        int popedElem = 0, count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println("size" + size);
            count = 0;
            popedElem = 0;
            while ((popedElem < size)) {
                Node head = q.remove();
                // System.out.println(head.data);
                popedElem++;
                if (isParent(head, a) && isParent(head, b)) return false;
                if (isParent(head, a) || isParent(head, b)) count++;
                if (count == 2) return true;

                if (head.left != null) {
                    System.out.println(head.left.data);
                    q.add(head.left);
                }
                if (head.right != null) {
                    System.out.println(head.right.data);
                    q.add(head.right);
                }


            }
            if (count == 1) return false;
            if (count == 2) return true;
        }

        return false;
    }

    boolean isParent(Node n, int ab) {
        if (n.left != null && n.left.data == ab || n.right != null && n.right.data == ab) return true;
        return false;
    }
}

// Java program to check if two binary tree are cousins
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
