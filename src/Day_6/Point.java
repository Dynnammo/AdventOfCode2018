/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_6;

import java.util.ArrayList;

/**
 *
 * @author dynnammo
 */
class Point {
    Coordinate referer;
    int manhattanDistance;
    boolean is_unusable;
    int abs;
    int ord;
    int totalDist;
    

    public Point() {
        this.manhattanDistance = Integer.MAX_VALUE;
        this.referer = new Coordinate(-1, -1, (char) 0);
    }
    
    
    public Point(int Xvalue, int Yvalue) {
        this.abs = Xvalue;
        this.ord = Yvalue;
        this.manhattanDistance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return "Point{" + "index=" + abs + ' '+ ord + '}';
    }

    void computeManDistPoint(ArrayList<Coordinate> coordinates) {
        totalDist = 0;
        for (Coordinate coordinate : coordinates) {
            int dist = computeManhattanDistance(coordinate);
            totalDist += dist;
            if (dist < manhattanDistance) {
                manhattanDistance = dist;
                referer = coordinate;
            }
            else if (dist == manhattanDistance)
                referer = new Coordinate(0,0,'.');
        }
    }

    private int computeManhattanDistance(Point coordinate) {
        int Xdist = Math.abs(this.abs - coordinate.abs);
        int Ydist = Math.abs(this.ord - coordinate.ord);
        return Xdist + Ydist;
    }
}
