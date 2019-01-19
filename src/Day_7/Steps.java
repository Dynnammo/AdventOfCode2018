/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_7;

import com.sun.org.apache.bcel.internal.generic.IFEQ;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import utils.FileReader;
import utils.MainClass;
import utils.Node;

/**
 *
 * @author dynnammo
 */
public class Steps extends MainClass{
    public ArrayList<Node> nodes = new ArrayList<>();
    public Set<Node> bag = new HashSet<>();
    public ArrayList<Node> order = new ArrayList<>();
    
    public void setNodes() throws FileNotFoundException{
        for (String s : new FileReader(this.getPath()).fileStream()) {
            String[] splitted = s.split("Step | must be finished before step | can begin.");
            Node root = new Node(splitted[1].charAt(0));
            Node child = new Node(splitted[2].charAt(0));
            setNode(root,child);
        }
    }
    
    private void setNode(Node r, Node c){
        Node root = getNode(r);
        Node child = getNode(c);
        root.addChild(child);
        child.addAncestor(root);
    }

    private Node getNode(Node n) {
        if (!nodes.contains(n)){
            nodes.add(n);
            return n;
        }
        else {
            for (Node node : nodes) {
                if (node.equals(n))
                    return nodes.get(nodes.indexOf(n));
            }
        }
        return null;
    }

    private void getRoots(){
        for (Node node : nodes) {
            if (node.ancestors.isEmpty()) 
               bag.add(node);
        }
    }
    
    public void order(){
        getRoots();
        while (!bag.isEmpty()) {            
            Node n = get_first_available();
            validate_node(n);
            remove_from_bag(n);
        }
    }
    
    @Override
    public String toString() {
        String s = "Steps{" + "nodes=";
        for (Node node : order)
            s += node.value + "";
        return s + '}';
    }
    
    private Node get_first_available(){
        char value = 255;
        for (Node node : bag) {
            value = (node.value < value && is_available(node)) ? node.value : value;
        }
        for (Node node : bag) {
            if (node.value == value)
                return node;
        }
        return null;
    }
    
    private void validate_node(Node n){
        order.add(n);
        n.children.forEach((child) -> {
            bag.add(child);
        });
    }

    private void remove_from_bag(Node n) {
        bag.remove(n);
    }

    private boolean is_available(Node node) {
        for (Node ancestor : node.ancestors) {
            if (!order.contains(ancestor))
                return false;
        }
        return true;
    }
}
