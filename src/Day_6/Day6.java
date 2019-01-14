/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_6;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author dynnammo
 */
public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Grid g = new Grid(System.getProperty("user.dir")+ "/src/Day_6/Points.txt");
        g.computePoints();
        ArrayList<Coordinate> coordinates = g.getCoordinateField();
//        for (Coordinate coordinate : coordinates)
//            System.out.println(coordinate.totalDist);
        g.getTotalDistanceGridSize(10000);
        System.out.println(g.greaterFieldSize);
//        System.out.println(g);
    }
}
