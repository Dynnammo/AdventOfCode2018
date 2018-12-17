/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author baptiste
 */
public class Day1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //First exercise
        Frequency freq1 = new Frequency(System.getProperty("user.dir") + "/src/Day_1/frequency.txt");
        freq1.analyseFile();
        
        //Second exercise
        Frequency freq2 = new Frequency(System.getProperty("user.dir")+"/src/Day_1/frequency.txt");
        freq2.getRepeatedSequence();
        System.out.println(freq2.valueRepeated);
    }
}
