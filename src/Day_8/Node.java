/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_8;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 *
 * @author dynnammo
 */
public class Node {
    int childrenVisited = 1;
    int childrenNumber = 0;
    ArrayList<Node> children = new ArrayList<Node>();
    Node fatherNode;
    int metadataNumber = 0 ;
    int[] metadata;
    int value;
    
    static int index = 0;
    static ArrayList<Integer> array = new ArrayList<>();

    public Node() {
    }
    
    Node(Node fatherNode, int index){
        this.fatherNode = fatherNode;
        childrenVisited = 0;
        childrenNumber = array.get(index);
        metadataNumber = array.get(index+1);
        Node.index += 2;
        if (childrenNumber == 0){
            setMetadata();
        }
    }

    Node(ArrayList<Integer> a) {
        Node.array = a;
    }
    
    public void setMetadata(){
        metadata = new int[metadataNumber];
        for (int i = 0; i < metadataNumber; i++) {
            metadata[i] = array.get(Node.index);
            Node.index++;
        }
    }

    void getNewChild(Node node) {
        this.children.add(node);
        this.childrenVisited++;
    }
    
    public int metadataSum(){
        return IntStream.of(this.metadata).sum();
    }
    
    public int nodeValue(){
        int value = 0;
        if(childrenNumber == 0){
            value = this.metadataSum();
        } else {
            for (int i = 0; i < metadataNumber; i++) {
                try {
                    value += children.get(metadata[i]-1).nodeValue();
                } catch(Exception e) {
                    System.out.println("Node does not exist !");
                }
            }
        }
        return value;
    }
}
