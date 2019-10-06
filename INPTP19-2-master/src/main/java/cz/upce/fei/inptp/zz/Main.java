package cz.upce.fei.inptp.zz;

import cz.upce.fei.inptp.zz.entity.DistanceMatrix;
import cz.upce.fei.inptp.zz.entity.DistanceMatrixLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VRP planner. Simple application to solve basic VRP. More will come later...
 * 
 */
public class Main {
    public static void main(String[] args) {
        try {
            DistanceMatrixLoader distanceMatrixLoader = new DistanceMatrixLoader("matrix1.csv");
            DistanceMatrix distanceMatrix = distanceMatrixLoader.load();
            
            System.out.println("A-C " + distanceMatrix.get("A", "C"));
            System.out.println("B-E " + distanceMatrix.get("B", "E"));
            System.out.println("D-D " + distanceMatrix.get("D", "D"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
