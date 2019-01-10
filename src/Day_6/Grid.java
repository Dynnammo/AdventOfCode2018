/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_6;

import com.sun.corba.se.impl.oa.toa.TOA;
import com.sun.org.apache.xml.internal.serializer.ToStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import utils.FileReader;
import utils.MainClass;
import utils.Matrix;

/**
 *
 * @author dynnammo
 */
public class Grid extends MainClass{
    Point[][] grid;
    ArrayList<Coordinate> coordinates =  new ArrayList<>();

    public Grid(String path) throws FileNotFoundException {
        super(path);
        extractCoordinates();
        resizeCoordinates();
        int[] extremeValues = getExtremeValues();
        this.grid = new Point[extremeValues[1]+2][extremeValues[3]+2];
        initializeGrid();
        addCoordinates();
    }
    
    
    public void extractCoordinates() throws FileNotFoundException{
        ArrayList<String> stream = new FileReader(this.getPath()).fileStream();
        char begin = 1;
        for (String s : stream) {
            String[] coordinate = s.split(", ");
            coordinates.add(
                new Coordinate(
                        Integer.parseInt(coordinate[1]),
                        Integer.parseInt(coordinate[0]),
                        begin
                )
            );
            begin++;
        }
    }

    public void resizeCoordinates() throws FileNotFoundException {
        int[] extremeValues = getExtremeValues();
        for (Coordinate p : coordinates) {
            p.abs -= (extremeValues[0]-1);
            p.ord -= extremeValues[2] -1;
        }
    }

    public int[] getExtremeValues(){
        int XminValue = Integer.MAX_VALUE;
        int XmaxValue = Integer.MIN_VALUE;
        int YminValue = Integer.MAX_VALUE;
        int YmaxValue = Integer.MIN_VALUE;

        for (Point s : coordinates) {
            int Xvalue = s.abs;
            int Yvalue = s.ord;
            if (Xvalue < XminValue)
                XminValue = Xvalue;
            if (Xvalue > XmaxValue)
                XmaxValue = Xvalue;
            if (Yvalue < YminValue)
                YminValue = Yvalue;
            if (Yvalue > YmaxValue)
                YmaxValue = Yvalue;
        }
        return new int[]{XminValue,XmaxValue,YminValue,YmaxValue};
    }
 
    public void addCoordinates(){
        for (Coordinate coordinate : coordinates)
            grid[coordinate.abs][coordinate.ord] = coordinate;
    }

    public void initializeGrid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
                grid[i][j] = new Point(i,j);
        }
    }
    
    public void computePoints(){
        for (Point[] points : grid) {
            for (Point point : points) {
                if (point.getClass() != Coordinate.class)
                        point.computePoint(coordinates);
                        int i = 0;
            }
        }
    }
    
    public ArrayList<Coordinate> getCoordinateField(){
        for (Point[] points : grid) {
            for (Point point : points)
                point.referer.fieldNumber++;
        }
        return pruneInfiniteFields();
    }
    
    @Override
    public String toString() {
        String toString = "";
        Point p = null;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++){
                p = grid[i][j];
                toString += p.referer.name ;
            }
            toString += '\n';
        }
        return toString;
    }

    private ArrayList<Coordinate> pruneInfiniteFields() {
        int[] val = getExtremeValues();
        ArrayList<Coordinate> prunedCoordinates = coordinates;
        Point[] upLine = grid[0];
        Point[] bottomLine = grid[val[1]+1];
        Point[] leftColumn = new Point[val[3]+1];
        Point[] rightColumn = new Point[grid.length];
        for (int i = 0; i < val[3]+1; i++) {
            leftColumn[i] = grid[i][0];
            rightColumn[i] = grid[i][val[3]+1];
        }
        for (int i = 0; i < val[3]+1; i++) {
            prunedCoordinates.remove(upLine[i].referer);
            prunedCoordinates.remove(bottomLine[i].referer);
            prunedCoordinates.remove(leftColumn[i].referer);
            prunedCoordinates.remove(rightColumn[i].referer);
        }
        return prunedCoordinates;
    }
}
