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
public class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;
    
    public BinaryNode(int value){
        this.value = value;
        right = null;
        left = null;
    }
    
    public BinaryNode insertNode(BinaryNode current, int value){
        if ( current == null){
            return new BinaryNode(value);
        }
        if (value < current.value)
            current.left = insertNode(current.left, value);
        else if (value > current.value)
            current.right = insertNode(current.right,value);
        else {
            return current;
        }
        return current;
    }
    
    public boolean findNode(BinaryNode current, int value){
        if (current == null){
            return false;
        }
        else {
            if (current.value == value)
                return true;
            else {
                if (current.value < value && current.right != null)
                    return current.right.findNode(current.right, value);
                else if (current.left != null)
                    return current.left.findNode(current.left, value);
            }             
        }
        return false;
    }
}
