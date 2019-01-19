/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_7;

import java.io.FileNotFoundException;
import utils.Node;

/**
 *
 * @author dynnammo
 */
public class Day_7 {
    public static void main(String[] args) throws FileNotFoundException {
        Steps s = new Steps();
        s.setPath(System.getProperty("user.dir")+ "/src/Day_7/Steps.txt");
        s.setNodes();
        s.order();
        System.out.println(s);
    }
}
