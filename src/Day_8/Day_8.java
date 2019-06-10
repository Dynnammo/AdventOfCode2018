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
        NodeFile nf = new NodeFile(System.getProperty("user.dir")+ "/src/Day_8/NodeFile.txt");
//        nf.getMetadataSum();
//        System.out.println(nf.metadataSum);
        nf.buildTree();
        nf.computeMetadata(nf.root);
        System.out.println(nf.metadataSum);
        nf.computeValue(nf.root.children.get(0));
        System.out.println(nf.value);
    }
}
