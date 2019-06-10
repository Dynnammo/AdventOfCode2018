/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_8;

import java.io.FileNotFoundException;

/**
 *
 * @author dynnammo
 */
public class Day_8 {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        Tree tree = new Tree(System.getProperty("user.dir")+ "/src/Day_8/NodeFile.txt");
        tree.buildTree();
        
        // Compute metadata sum
        tree.computeMetadata(tree.root);
        
        // Compute value of root
        tree.computeValue(tree.root.children.get(0));
        
        System.out.println(tree.metadataSum + " " + tree.value);
    }
}
