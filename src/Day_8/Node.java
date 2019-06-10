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
public final class Node {
    ArrayList<Node> children = new ArrayList<>();
    Node fatherNode;
    int childrenVisited;
    int childrenNumber;
    
    int metadataNumber = 0 ;
    int[] metadata;
    int value;

    
    static int index = 0;
    static ArrayList<Integer> array = new ArrayList<>();
    
    Node(Node father){
        fatherNode = father;
        childrenVisited = 0;
        childrenNumber = array.get(index++);
        metadataNumber = array.get(index++);
        metadata = new int[metadataNumber];
        if (childrenNumber == 0)
            setMetadata();
    }

    // Constructor reserved for the root
    Node(ArrayList<Integer> a) {
        childrenVisited = 1;
        childrenNumber = 0;
        array = a;
    }
    
    public void setMetadata(){
        for (int i = 0; i < metadataNumber; i++)
            metadata[i] = array.get(index++);
    }

    void getNewChild(Node node) {
        children.add(node);
        childrenVisited++;
    }
    
    public int metadataSum(){
        return IntStream.of(metadata).sum();
    }
    
    public int nodeValue(){
        value = 0;
        if(childrenNumber == 0){
            value = this.metadataSum();
        } else {
            for (int i = 0; i < metadataNumber; i++) {
                try {
                    value += children.get(metadata[i]-1).nodeValue();
                } catch(Exception e) {}
            }
        }
        return value;
    }
}
