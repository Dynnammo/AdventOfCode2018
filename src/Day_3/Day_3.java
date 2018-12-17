/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_3;

import java.io.FileNotFoundException;

/**
 *
 * @author dynnammo
 */
public class Day_3 {
    public static void main(String[] args) throws FileNotFoundException{
        int size = 1000;
        String path = System.getProperty("user.dir") + "/src/Day_3/FabricPiece.txt";
        FactoryPiece fp = new FactoryPiece(size,path);
        fp.parseClaims();
        fp.executeClaims();
        int overlap = fp.getOverlapClaims();
        System.out.println(overlap);
        int pureClaim = fp.getPureClaim();
        System.out.println(pureClaim);
    }
    
}
