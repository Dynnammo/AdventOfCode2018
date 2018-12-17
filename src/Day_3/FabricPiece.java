/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.FileReader;
import utils.Matrix;

/**
 *
 * @author dynnammo
 */
public class FabricPiece {
    ArrayList<int[]> claims;
    Matrix piece;

    public FabricPiece() {
        piece = new Matrix(1000);
        claims = new ArrayList<>();
    }
            
    
    
    public void parseClaims(String path) throws FileNotFoundException{
        for (Object claim : new FileReader(path).fileStream()) {
            String claimString = (String) claim;
            String[] splited = claimString.split(" ");
            String[] distances = {splited[2].split(",")[0],splited[2].split(",")[1]};
            int leftDistance = Integer.parseInt(distances[0]);
            int topDistance = Integer.parseInt(distances[1].substring(0, distances[1].length()-1));
            int rowNumber = Integer.parseInt(splited[3].split("x")[0]);
            int columnNumber = Integer.parseInt(splited[3].split("x")[1]);
            int[] claimParsed = {
                leftDistance,
                topDistance,
                rowNumber,
                columnNumber
            };
            claims.add(claimParsed);
        }
    }

    protected void executeClaims() {
        for (int[] claim : claims) {
            Matrix m = new Matrix(1000);
            int[] size = {claim[2],claim[3]};
            m.fillSquare(claim[0], claim[1], size);
            piece.sum(m);
        }
    }

    int getOverlapClaims() {
        int overlapCounter = 0;
        for (int i = 0; i < piece.getSize(); i++) {
            for (int j = 0; j < piece.getSize(); j++) {
                if (piece.getM()[i][j] > 1) {
                    overlapCounter++;
                }
            }
        }
        return overlapCounter;
    }    
}
