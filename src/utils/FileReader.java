/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author baptiste
 */
public class FileReader {
    protected String path;
    
    public FileReader(String path){
        this.path = path;
    }
    
    public ArrayList<String> fileStream() throws FileNotFoundException {
        File f = new File(this.path);
        java.io.FileReader fr = new java.io.FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> arrayStrings = new ArrayList<>();
        Object[] stream = br.lines().toArray();
        for (Object obj : stream)
            arrayStrings.add((String) obj);
        return arrayStrings;
    }
}
