/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author baptiste
 */
public class mainUtils {
    public static void main(String[] args) throws ParseException {
        // Binary tree+ Node
//        BinaryTree bt =  new BinaryTree(20);
//        bt.insertNode(0);
//        bt.insertNode(40);        
//        System.out.println(bt.findNode(40));
        
//        // Dictionnary
//        Dictionnary d = new Dictionnary();
//        d.print();

        // Matrix
//        Matrix m = new Matrix(10);
//        Matrix n =  new Matrix(10);
//        int[] size = {4,4};
//        m.fillSquare(1, 3, size);
//        n.fillSquare(3, 1, size);
//        m.sum(n);
//        System.out.println(m.toString());
        
        // Date Management
        String s1 = "[2018-11-06 00:46]";
        String s2 = "[2018-11-06 00:45]";
        DateManager dm = new DateManager();
        Date d1 = new DateManager().parseString(s1);
        Date d2 = new DateManager().parseString(s2);
        System.out.println(d1.after(d2));;
    }
}
