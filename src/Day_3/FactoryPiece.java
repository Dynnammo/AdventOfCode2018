/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.FileReader;
import utils.MainClass;
import utils.Matrix;

/**
 *
 * @author dynnammo
 */
public class FactoryPiece extends MainClass{
    ArrayList<Claim> claims;
    Matrix piece;
    int size;

    public FactoryPiece(int size, String path) {
        super(path);
        this.size=size;
        piece = new Matrix(size);
        claims = new ArrayList<>();
    }
            
    
    
    public void parseClaims() throws FileNotFoundException{
        for (String claimString : new FileReader(this.getPath()).fileStream()) {
            Claim c = new Claim();
            c.parseString(claimString);
            claims.add(c);
        }
    }

    protected void executeClaims() {
        for (Claim claim : claims) {
            Matrix m = new Matrix(size);
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
    
    int getPureClaim(){
        for (Claim c : claims) {
            c.isPure = true;
            outerloop:
                for (int j = c.topDistance; j < c.topDistance+c.size[1]; j++) {
                    for (int i = c.leftDistance; i < c.leftDistance+c.size[0]; i++) {
                        if (this.piece.getM()[j][i] != 1) {
                            c.isPure = false;
                            break outerloop;
                        }
                    }
                }
                if (c.isPure)
                    return c.ID;
        }
        return -1;
    }
}
