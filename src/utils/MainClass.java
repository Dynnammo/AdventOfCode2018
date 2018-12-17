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
public class MainClass {
    String path;

    public MainClass(String path) {
        this.path = path;
    }
    
    public MainClass(){
        path = "";
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
