/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_9;

/**
 *
 * @author dynnammo
 */
public class Day_9 {
    public static void main(String[] args) {
        Game g = new Game(464,7091800);
        g.execute();
        long[] results = g.getWinner();
        System.out.println(results[0] + " " + results[1]);
    }
}
