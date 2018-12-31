/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.FileReader;
import utils.MainClass;

/**
 *
 * @author dynnammo
 */


public class Polymer extends MainClass{
    public String chain;
    
    public Polymer(String path) throws FileNotFoundException{
        super(path);
        chain = new FileReader(this.getPath()).fileStream().get(0);
    }

    public Polymer() {
        
    }

//    Improved implementation : modify dynamically the chain while
//    looping on it /!\ Need spliting strings to be executed
//    Less than 1 second for solving XD
    
    public String simulateReaction(String chain){
        char[] chainArray = chain.toCharArray();
        String recursiveChain = chain;
        for (int i = 0; i < chainArray.length; i++) {
            try {
                if (Math.abs(chainArray[i]-chainArray[i+1]) == 32) {
                    recursiveChain = chain.substring(0, i)+ chain.substring(i+2);
                    break;
                }
            } catch (Exception e) {}
        }
        if (recursiveChain == chain)
            return chain;
        return simulateReaction(recursiveChain);
    }
    
    
    
//    Naive implementation: need about 2 min to compute the answer
    public void simulateFullReaction(){
        for (int i = 0; i < 5000; i++)
            simulateReactionStep();
    }
    
    public int simulateReactionStep(){
        chain += " ";
        char[] chainArray = chain.toCharArray();
        String newChain = "";
        for (int i = 0; i < chainArray.length; i++) {
            if (chainArray[i] != ' ') {
                if (Math.abs(chainArray[i]-chainArray[i+1]) != 32)
                    newChain += chainArray[i];
                else
                    i++;
            }
        }
        chain = newChain;
        return chain.length();
    }

    @Override
    public String toString() {
        return "Polymer{" + "chain=" + chain + '}';
    }
}
