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
import utils.MainClass;
/**
 *
 * @author baptiste
 */
public class Frequency extends MainClass{
    protected int valueRepeated;
    protected int sum;
    protected ArrayList array;
    
    
    public Frequency(){
        super();
        valueRepeated = Integer.MAX_VALUE;
        sum = 0;
        array = new ArrayList();
    }

    public Frequency(String path) {
        super(path);
        array = new ArrayList();
        valueRepeated = Integer.MAX_VALUE;
        sum = 0;
    }
    
    public void analyseFile() throws FileSystemException, FileNotFoundException, IOException{
        array.clear();
        for (String s : new FileReader(this.getPath()).fileStream()){
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
}
