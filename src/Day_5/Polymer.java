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
    
    public void simulateReaction(){
        for (int i = 0; i < chain.length(); i++) {
            try {
                char current = chain.charAt(i);
                char next = chain.charAt(i+1);
                if (Math.abs(current - next) == 32) {
                    chain = chain.substring(0,i) + chain.substring(i+2);
                    i-=2;
                }
            } catch (Exception e) {}
        }
    }
    
    public int getImprovedPolymer(){
        String alphabeat = "abcdefghijklmnopqrstuvwxyz";
        int minLength = Integer.MAX_VALUE;
        for (char c : alphabeat.toCharArray()) {
            String modifiedChain = chain.replace(c+"", "");
            modifiedChain = modifiedChain.replace((c+"").toUpperCase(), "");
            Polymer modifiedPolymer = new Polymer();
            modifiedPolymer.chain = modifiedChain;
            modifiedPolymer.simulateReaction();
            if (modifiedPolymer.chain.length() < minLength)
                minLength = modifiedPolymer.chain.length();
        }
        return minLength;
    }
  
    @Override
    public String toString() {
        return "Polymer{" + "chain=" + chain + '}';
    }
}
