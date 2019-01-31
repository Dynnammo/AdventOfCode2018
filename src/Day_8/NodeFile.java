/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.FileReader;
import utils.MainClass;

/**
 *
 * @author dynnammo
 */
class NodeFile extends MainClass{
    ArrayList<Integer> a = new ArrayList<>();
    int metadataSum = 0;
    
    NodeFile(String path) throws FileNotFoundException{
        this.setPath(path);
        for (String s : new FileReader(this.getPath()).oneLineStream())
            a.add(Integer.parseInt(s));
    }

    void getMetadataSum() throws java.lang.Exception {
        getMetadataSum(0);
    }
    
    private void getMetadataSum(int i) throws java.lang.Exception {
        int nbChild = a.get(i);
        if (nbChild == 0) {
            if (i != 0)
                a.set(i-2, (int) a.get(i-2)-1);
            int nbMetadata = a.get(i+1);
            a.remove(i);
            a.remove(i);
            for (int j = 0; j < nbMetadata; j++){
                metadataSum += a.get(i);
                a.remove(i);
            }
            if (a.isEmpty())
                return;
            getMetadataSum(i-2);
        }
        if (a.isEmpty()) {
            return;
        }
        getMetadataSum(i+2);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer integer : a)
            s += integer + " ";
        return s;
    }

    private Exception Exception() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
