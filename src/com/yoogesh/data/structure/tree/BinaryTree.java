package com.yoogesh.data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {

    static int index = -1;

    public Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node node = new Node(nodes[index]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public void preOrder(Node node) { // [DLR]
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) { // [LDR]
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) { // [LRD]
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.data + " ");
    }


    /*
    int[] nodes = { 15, 13, 7, 1, -1, -1, 2, -1, -1, 6, -1, -1, 12, -1, -1 };


    1) if the tree is null return a message saying "tree is empty"
    2) create a queue and put the root element in a queue. since there is only one element in a root, add null to the queue after that

                   |-----------------------
                   |   15   null
                   |-----------------------

    3) create a while loop and run it until it is not empty
        - Poll (pop) the item from a queue
        - If the popped is not null, then print the value to console. if it has left child add to the queue. Also if it has right child add to the queue.
        - if the popped value is null btw and queue not empty, this means there still has items on the queue. So if this is the case, add back the null to the
        queue again. and print a new line to a console to indicate you are going to another level
     */
    public void levelOrderTraversal(Node node) {
        if (node == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            }
        }
    }

    public int countNodes(Node node) {
        if (node == null)
            return 0;
        int ln = countNodes(node.left);
        int rn = countNodes(node.right);
        return ln + rn + 1;
    }

    public int sumOfNodes(Node node) {
        if (node == null)
            return 0;
        int ls = sumOfNodes(node.left);
        int rs = sumOfNodes(node.right);
        return ls + rs + node.data;
    }

    public int height(Node node) {
        if (null == node)
            return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public boolean search(Node node, int data) {
        if (null == node)
            return false;
        if (node.data == data)
            return true;
        if (search(node.left, data)) {
            return true;
        }
        if (search(node.right, data)) {
            return true;
        }
        return false;
    }

    public int maxElement(Node node) {
        int max, left, right;
        if (node == null)
            return Integer.MIN_VALUE;
        max = node.data;
        left = maxElement(node.left);
        right = maxElement(node.right);
        if (left > max)
            max = left;
        if (right > max)
            max = right;
        return max;
    }

    public int minElement(Node node) {
        int min, left, right;
        if (node == null)
            return Integer.MAX_VALUE;
        min = node.data;
        left = minElement(node.left);
        right = minElement(node.right);
        if (left < min)
            min = left;
        if (right < min)
            min = right;
        return min;
    }

    public boolean isEqual(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null) {
            return false;
        }
        return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right) && (node1.data == node2.data);
    }

    public Node copyTree(Node node) {
        Node temp;
        if (node != null) {
            temp = new Node(node.data);
            temp.left = copyTree(node.left);
            temp.right = copyTree(node.right);
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nodes = {15, 13, 7, 1, -1, -1, 2, -1, -1, 6, -1, -1, 12, -1, -1};
        BinaryTree demo = new BinaryTree();
        Node tree = demo.buildTree(nodes);

        /*
         * 15 13 12 7 6 1 2
         *
         *
         * In-order: 1-7-2-13-6-15-12 [LDR] Pre-order: 15-13-7-1-2-6-12 [DLR]
         * Post-order: 1-7-2-13-6-12-15 [LRD]
         *
         */
        System.out.println(tree.data); // 15
        System.out.println(tree.left.data); // 13
        System.out.println(tree.right.data); // 12

        demo.inOrder(tree); // 1 - 7 - 2 - 13 - 6 - 15 - 12
        System.out.println();

        demo.preOrder(tree); // 15 - 13 - 7 - 1 - 2 - 6 - 12
        System.out.println();

        demo.postOrder(tree); // 1 - 7 - 2 - 13 - 6 - 12 - 15
        System.out.println();

        /*
         * Level order traversing 15 13 12 7 6 1 2
         *
         */

        System.out.println("\n\n-------- Start: Level order traversing ------------");
        demo.levelOrderTraversal(tree);
        System.out.println("-------- End: Level order traversing ------------");

        System.out.println("\n\n-------- Total Node count is ------------" + demo.countNodes(tree)); // 7
        System.out.println("Total Sum of Node is ------------" + demo.sumOfNodes(tree)); // 56
        System.out.println("Height of Node is ------------" + demo.height(tree)); // 4
        System.out.println("Is 1 available in this tree? ------------" + demo.search(tree, 1)); // true
        System.out.println("Max element in a node is ------------" + demo.maxElement(tree)); // 15
        System.out.println("Min element in a node is ------------" + demo.minElement(tree)); // 1
    }

}
