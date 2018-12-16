/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_2;

import java.io.FileNotFoundException;

/**
 *
 * @author baptiste
 */
public class Day2 {
    public static void main(String[] args) throws FileNotFoundException{
        Checksum checksum = new Checksum(System.getProperty("user.dir")+"/src/Day_2/boxIDs.txt");
        
        //First exercise
        checksum.computeChecksum();
        System.out.println(checksum.toString());
        
        //Second exercise
        checksum.computePrototypes();
        System.out.println(checksum.prototype);
    }
}
