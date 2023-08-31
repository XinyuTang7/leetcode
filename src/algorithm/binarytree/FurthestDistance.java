package algorithm.binarytree;

public class FurthestDistance {
    /**
     * 二叉树节点间的最远距离
     *           8
     *          /\
     *         4  6
     *        /\  /\
     *       1 3 0  5
     * @param node
     */


    public static int furthestDistance(Node node) {
        if (node == null) return 0;
        return process(node).furthestDistance;
    }

    public static Info process(Node node) {
        if (node == null) return new Info(0, 0);
        Info left = process(node.left);
        Info right = process(node.right);
        int p1 = left.furthestDistance;
        int p2 = right.furthestDistance;
        int p3 = left.height + right.height + 1;
        int furthestDistance = Math.max(p3, Math.max(p1, p2));
        int height = Math.max(left.height, right.height) + 1;
        return new Info(furthestDistance, height);
    }

    public static class Info {
        public int furthestDistance;
        public int height;

        public Info(int furthestDistance, int height) {
            this.furthestDistance = furthestDistance;
            this.height = height;
        }
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
        System.out.println(furthestDistance(node1));
    }
}
