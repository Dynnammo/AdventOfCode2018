/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.Dictionnary;
import utils.FileReader;
import utils.MainClass;

/**
 *
 * @author baptiste
 */
public class Checksum  extends MainClass{
    ArrayList<BoxID> boxList;
    int doubles;
    int triples;
    int checksum;
    String prototype;

    public Checksum(String path) throws FileNotFoundException {
        super(path);
        boxList = new ArrayList<>();
        for (String boxID : new FileReader(path).fileStream())
            boxList.add(new BoxID(boxID));
    }
    
    public void computeBoxID() throws FileNotFoundException{
        for (BoxID bi : boxList) {
            bi.computeOccurences();
            if (bi.dictionnary.dictionnary.containsValue(2))
                doubles++;
            if (bi.dictionnary.dictionnary.containsValue(3))
                triples++;
        }
    }
    
    public void computeChecksum() throws FileNotFoundException{
        computeBoxID();
        checksum = doubles*triples;
    }

    public void computePrototypes(){
        for (int i = 0; i < boxList.size(); i++) {
            BoxID firstBox = boxList.get(i);
            for (int j = i+1; j < boxList.size(); j++) {
                BoxID secondBox = boxList.get(j);
                if (firstBox.compareBox(secondBox))
                    this.prototype = firstBox.commonParts(secondBox);
            }
        }
    }

    @Override
    public String toString() {
        return "Checksum{" + "doubles=" + doubles + ", triples=" + triples + ", checksum=" + checksum + '}';
    }
    
    
}