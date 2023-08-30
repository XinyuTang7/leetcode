package algorithm.binarytree;

public class Ergodic {
    /**
     * 二叉树的遍历
     *           8
     *          /\
     *         4  6
     *        /\  /\
     *       1 3 0  5
     */

    public static void ergodic(Node node){
        if(node == null){
            return;
        }
        //前序遍历
        System.out.println(node.value);
        ergodic(node.left);
        //中序遍历
        ergodic(node.right);
        //后序遍历
    }
    public static void main(String[] args) {
        Node node1 = new Node(8);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(1);
        Node node5 = new Node(3);
        Node node6 = new Node(0);
        Node node7 = new Node(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        node7.left = null;
        node7.right = null;

        ergodic(node1);
    }
}
