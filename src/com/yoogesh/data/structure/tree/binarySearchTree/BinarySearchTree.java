package com.yoogesh.data.structure.tree.binarySearchTree;

import com.yoogesh.data.structure.tree.Node;

public class BinarySearchTree {

    public Node root = null;

    public void insertNode(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {
        if(node == null){
            return new Node(data);
        }
        if(data < node.data){
            node.left = insertNode(node.left, data);
        } else if( data > node.data) {
            node.right = insertNode(node.right, data);
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        for(int i=1; i<=10; i++){
            tree.insertNode(i);
        }
        System.out.println(tree.root.data);
    }


    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
}

