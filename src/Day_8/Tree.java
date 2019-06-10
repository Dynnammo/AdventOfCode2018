/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.FileReader;
import utils.MainClass;

/**
 *
 * @author dynnammo
 */

class Tree extends MainClass{
    ArrayList<Integer> a = new ArrayList<>();
    int metadataSum = 0;
    int value = 0;
    Node root;
    Tree(String path) throws FileNotFoundException{
        this.setPath(path);
        for (String s : new FileReader(this.getPath()).oneLineStream())
            a.add(Integer.parseInt(s));
        root = new Node(a);
    }
    
    void buildTree(){
        buildNode(root);
    }
    
    void buildNode(Node fatherNode){
        Node currentNode = new Node(fatherNode);
        fatherNode.getNewChild(currentNode);
        if (a.get(Node.index) == 0)
            currentNode.getNewChild(new Node(currentNode));
        while (currentNode.childrenVisited != currentNode.childrenNumber)
            buildNode(currentNode);
        currentNode.setMetadata();
    }
    
    void computeMetadata(Node origin){
        for (Node node : origin.children) {
            metadataSum += node.metadataSum();
            computeMetadata(node);
        }
    }
    
    void computeValue(Node origin){
        value = origin.nodeValue();
    }
}
