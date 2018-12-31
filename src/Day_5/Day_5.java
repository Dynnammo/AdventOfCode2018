/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_5;

import java.io.FileNotFoundException;

/**
 *
 * @author dynnammo
 */

public class Day_5 {
    final int GAP = 32;
    public static void main(String[] args) throws FileNotFoundException {
        Polymer polymer = new Polymer(System.getProperty("user.dir")+ "/src/Day_5/Polymer.txt");
//        String chain = "";
//        for (int i = 0; i < polymer.chain.length()/5000; i++)
//            chain += polymer.simulateReaction(polymer.chain.substring(5000*i, 5000*(i+1)));
//        chain = polymer.simulateReaction(chain);
//        System.out.println(chain.length());

        polymer.simulateFullReaction();
        System.out.println(polymer.chain.length());
    }
    
    
}