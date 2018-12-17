/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_1;

import utils.BinaryTree;
import utils.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
/**
 *
 * @author baptiste
 */
public class Frequency {
    protected int valueRepeated;
    protected int sum;
    protected String path;
    protected ArrayList array;
    
    
    public Frequency(){
        valueRepeated = Integer.MAX_VALUE;
        sum = 0;
        path = "";
        array = new ArrayList();
    }
    
    public void analyseFile() throws FileSystemException, FileNotFoundException, IOException{
        array.clear();
        for (String s : new FileReader(path).fileStream()){
            char operation = s.charAt(0);
            int i = Integer.parseInt(s.substring(1));
            if (operation == '+')
                sum += i;
            else
                sum -= i;
            array.add(sum);
        }
    }
    
    public void getRepeatedSequence() throws FileSystemException, FileNotFoundException, IOException{
        BinaryTree bt = new BinaryTree(0);
        while (valueRepeated == Integer.MAX_VALUE){
            analyseFile();
            for (Object nb : array) {
                int i = (int) nb;
                if (bt.findNode(i)){
                    valueRepeated = i;
                    break;
                }
                else
                    bt.insertNode(i);
            }
        }
    }

    public void setPath(String path) {
        this.path = path;
    }
}
