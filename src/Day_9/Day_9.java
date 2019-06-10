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
        Game g = new Game(464,70918);
        g.execute();
        int[] results = g.getWinner();
        System.out.println(results[0] + " " + results[1]);
    }
}
