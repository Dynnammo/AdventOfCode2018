/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_3;

/**
 *
 * @author dynnammo
 */
public class Claim {
    public int leftDistance;
    public int topDistance;
    public int[] size;

    public Claim(int leftDistance, int topDistance, int[] size) {
        this.leftDistance = leftDistance;
        this.topDistance = topDistance;
        this.size = size;
    }

    Claim() {
        
    }

    public void parseString(String claimString) {
        String[] splited = claimString.split(" ");
        String[] distances = {splited[2].split(",")[0],splited[2].split(",")[1]};
        leftDistance = Integer.parseInt(distances[0]);
        topDistance = Integer.parseInt(distances[1].substring(0, distances[1].length()-1));
        size = new int[] {
            Integer.parseInt(splited[3].split("x")[0]),
            Integer.parseInt(splited[3].split("x")[1])
        }; 
    }
}



