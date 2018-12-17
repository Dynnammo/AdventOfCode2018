/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author dynnammo
 */
public class Matrix {
    int size;
    int[][] m;
    
    public Matrix(int size){
        this.size = size;
        m = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                m[i][j] = 0;
        }
    }
    
    public void sum(Matrix b){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                m[i][j] += b.m[i][j];
        }
    }
    
    public void fillSquare(int leftDistance, int topDistance,int[] size){
        for (int j = topDistance; j < topDistance+size[1]; j++) {
            for (int i = leftDistance; i < leftDistance+size[0]; i++) {
                m[j][i] = 1;
            }
        }
    }
    
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                s += (m[i][j] + " ");
            }
            s += "\n";
        }
        return s;
    }

    public int getSize() {
        return size;
    }

    public int[][] getM() {
        return m;
    }
    
    
    
    
}
