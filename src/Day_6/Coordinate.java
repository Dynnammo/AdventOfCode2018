/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_6;

/**
 *
 * @author dynnammo
 */
public class Coordinate extends Point{
    char name;
    int fieldNumber;

    public Coordinate(int Xvalue, int Yvalue, char name) {
        super(Xvalue, Yvalue);
        this.name = name;
        this.referer = this;
    }

    @Override
    public String toString() {
        return "Coordinate{" + "name=" + name + ", fieldNumber=" + fieldNumber + '}';
    }
    
    
}
