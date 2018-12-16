/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author baptiste
 */
public class BinaryTree {
    public Node root;

    public BinaryTree(int value) {
        root = new Node(value);
    }
    
    public BinaryTree(Node node){
        this.root = node;
    }
    
    public BinaryTree(){}
    
    public void toString(Node current) {
        if (current == null)
            System.out.println("");
        else{
            System.out.println(current.value);
            this.toString(current.left);
            this.toString(current.right);
        }
    }

    public void insertNode(int i) {
         root.insertNode(root, i);
    }
    
    public boolean findNode(int i){
        return root.findNode(root, i);
    }
}
