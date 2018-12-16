/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.HashMap;

/**
 *
 * @author baptiste
 */
public class Dictionnary {
    protected String alphabet;
    public HashMap dictionnary;
    
    public Dictionnary(){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        dictionnary = new HashMap();
        for (int i = 0; i < alphabet.length();i++) {
            dictionnary.put(alphabet.charAt(i), 0);
        }
    }
    
    public void incrementKey(char key){
        int val = (int) dictionnary.get(key);
        dictionnary.put(key, ++val);
    }

    public void print() {
        System.out.println("Alphabeat" + alphabet);
        for (Object key : dictionnary.keySet()) {
            System.out.println("Key : " + key + " Value: " + dictionnary.get(key));
        }
    }
    
    
}
