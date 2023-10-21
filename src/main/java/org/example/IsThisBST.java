package org.example;

class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }
}

public class IsThisBST {

    public static void main(String[] args) {
        Node root3 = new Node(3);

        root3.left = new Node(5);
        root3.right = new Node(2);

        Node temp5 = root3.left;

        temp5.left = new Node(7);
        temp5.right = new Node(4);

        Node temp2 = root3.right;

        temp2.left = new Node(6);


        checkBST(root3);
    }


    static boolean checkBST(Node root) {
        return checkWithConstraints(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkWithConstraints(Node node, int min, int max) {
        if (node == null)
            return true;

        boolean leftFlag;
        boolean rightFlag;

        if (node.data >= max || node.data <= min) {
            return false;
        }

        leftFlag = checkWithConstraints(node.left, min, node.data);
        rightFlag = checkWithConstraints(node.right, node.data, max);

        return leftFlag && rightFlag;
    }


//    static boolean checkBST(Node root) {
//        return checkWithConstraints(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    static boolean checkWithConstraints(Node node, int min, int max) {
//        boolean leftFlag = true;
//        boolean rightFlag = true;
//
//        if (node.data >= max || node.data <= min) {
//            return false;
//        }
//        if (node.left != null) {
//            leftFlag = checkWithConstraints(node.left, min, node.data);
//        }
//        if (node.right != null) {
//            rightFlag = checkWithConstraints(node.right, node.data, max);
//        }
//        return leftFlag && rightFlag;
//    }

    /**
     * old solution
     * */
//    boolean checkBST(Node root) {
//        return checkNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    boolean checkNode(Node x, int min, int max) {
//        if (x == null)
//            return true;
//
//        boolean leftFlag = true;
//        boolean rightFlag = true;
//
//        if (x.data > min && x.data < max) {
//            leftFlag = checkNode(x.left, min, x.data);
//            rightFlag = checkNode(x.right, x.data, max);
//        } else
//            return false;
//
//        return leftFlag && rightFlag;
//    }

}
