/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author dynnammo
 */
public class Node {
    public char value;
    public ArrayList<Node> children = new ArrayList<>();
    public ArrayList<Node> ancestors = new ArrayList<>();

    public Node(char value) {
        this.value = value;
    }
    
    public void addChild(Node child){
        if (!children.contains(child))
            children.add(child); 
    }
    
    public void addAncestor(Node ancestor){
        if (!ancestors.contains(ancestor))
            ancestors.add(ancestor);
    }

    @Override
    public String toString() {
        String s = "Node{ \n" + "value=" + value + "\n children= ";
        for (Node node : children) {
            s += node.value + " ";
        }
        s += "\n ancestors =";
        for (Node ancestor : ancestors) {
            s += ancestor.value + " ";
        }
        s += '}';
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.value;
        hash = 61 * hash + Objects.hashCode(this.children);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        return this.value == other.value;
    }
}
