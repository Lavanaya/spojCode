package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class pathBtwn2Nodes {

    static boolean aPresent=false,bPresent=false;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Node> list = findLCA(root, root.left.left, root.left.right, new ArrayList<>());
        if( !(aPresent&&bPresent)) {
            int index=0;
            while(list.size()!=1)list.remove(index);
            List<Node> left=findLCA(list.get(list.size()-1).left, root.right.left, root.left.right, new ArrayList<Node>());
            if(left!=null) list.addAll(left);
            else {
                list.addAll(findLCA(list.get(list.size()-1).right, root.right.left, root.left.right, new ArrayList<>()));
            }
        }

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).data);


    }

    public static List<Node> findLCA(Node root, Node a, Node b, List<Node> list) {
        if (root == null) return null;
        if (root == a || root == b) {
            List<Node> list2 = new ArrayList<>();
            list2.addAll(list);
            list2.add(root);
            if(root==a) aPresent=true;
            else bPresent=true;
            return list2;
        }
        list.add(root);

       /* List<Node> lList= findLCA(root.left,a,b,new ArrayList<>(list));
        List<Node> rList=findLCA(root.right,a,b, new ArrayList<>(list));*/

        List<Node> lList = findLCA(root.left, a, b, list);
        List<Node> rList = findLCA(root.right, a, b, list);


        list.remove(list.size() - 1);
        if (lList != null & rList != null) {

            for (int i = 0; i < lList.size(); i++) {
                if (lList.get(i).data == (root.data)) {
                    lList.remove(i);
                    break;
                }
                lList.remove(i);
                i--;
            }

            for (int i = 0; i < rList.size(); i++) {
                if (rList.get(i).data == (root.data)) break;
                rList.remove(i);
                i--;
            }

            lList.addAll(rList);
            return lList;
        }

        return lList != null ? lList : rList;

    }
}



