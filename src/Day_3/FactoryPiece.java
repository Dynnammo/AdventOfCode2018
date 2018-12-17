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
public class FactoryPiece {
    ArrayList<Claim> claims;
    Matrix piece;

    public FactoryPiece() {
        piece = new Matrix(1000);
        claims = new ArrayList<>();
    }
            
    
    
    public void parseClaims(String path) throws FileNotFoundException{
        for (String claimString : new FileReader(path).fileStream()) {
            Claim c = new Claim();
            c.parseString(claimString);
            claims.add(c);
        }
    }

    protected void executeClaims() {
        for (Claim claim : claims) {
            Matrix m = new Matrix(1000);
            m.fillSquare(claim);
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
    
//    int getPureClaim(){
//        for (int[] claim : claims) {
//            for (int i = claim[0]; i < claim[1]+claim[3]; i++) {
//                for (int j = 0; j < claim[0]+claim[2]; j++) {
//                    if (this.piece.getM()[j][i] != 1) {
//                        
//                    }
//                }
//            }
//        }
//    }
}
