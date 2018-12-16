/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_2;

import utils.Dictionnary;

/**
 *
 * @author baptiste
 */
public class BoxID{
    String boxID;
    Dictionnary dictionnary;

    public BoxID(String boxID) {
        this.boxID = boxID;
        this.dictionnary = new Dictionnary();
    }
    
    public void computeOccurences(){
        for (int i = 0; i < boxID.length(); i++) {
            dictionnary.incrementKey(boxID.charAt(i));
        }
    }

    boolean compareBox(BoxID secondBox) {
        int differenceCounter = 0;
        for (int i = 0; i < boxID.length(); i++) {
            if (boxID.charAt(i) != secondBox.boxID.charAt(i))
                differenceCounter++;
        }
        return (differenceCounter == 1);
    }

    String commonParts(BoxID secondBox) {
        String commonParts = "";
        for (int i = 0; i < boxID.length(); i++) {
            if (boxID.charAt(i) == secondBox.boxID.charAt(i)) {
                commonParts += boxID.charAt(i);
            }
        }
        return commonParts;
    }
}
