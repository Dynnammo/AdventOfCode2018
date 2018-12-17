/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Day_3.Claim;

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
    
    public void fillSquare(Claim c){
        for (int j = c.topDistance; j < c.topDistance+c.size[1]; j++) {
            for (int i = c.leftDistance; i < c.leftDistance+c.size[0]; i++) {
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
