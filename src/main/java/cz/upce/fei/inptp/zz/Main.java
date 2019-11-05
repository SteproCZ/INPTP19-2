package cz.upce.fei.inptp.zz;

import cz.upce.fei.inptp.zz.entity.DistanceMatrix;
import cz.upce.fei.inptp.zz.entity.DistanceMatrixLoader;

/**
 * VRP planner. Simple application to solve basic VRP. More will come later...
 * 
 */
public class Main {
    public static void main(String[] args) {
        DistanceMatrixLoader dml = new DistanceMatrixLoader("matrix1.csv");
        DistanceMatrix dm = dml.load();
        
        System.out.println("A-C " + dm.getDistanceBetweenLocations("A", "C"));
        System.out.println("B-E " + dm.getDistanceBetweenLocations("B", "E"));
        System.out.println("D-D " + dm.getDistanceBetweenLocations("D", "D"));
        double coefficientCapacity = ((double)3/5);
        System.out.println(coefficientCapacity);
        System.out.println(23 * coefficientCapacity);
        System.out.println((int)(23 + 23 * coefficientCapacity));
    }
}
