/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_7;

import java.io.FileNotFoundException;

/**
 *
 * @author dynnammo
 */
public class Day_7 {
    public static void main(String[] args) throws FileNotFoundException {
        Steps s = new Steps();
        s.setPath(System.getProperty("user.dir")+ "/src/Day_7/Steps.txt");
        s.setTasks();
//        s.order();
        int time = s.getExecutionTime(5);
        System.out.println(time);
    }
}
