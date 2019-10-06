/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Roman
 */
public class DistanceMatrixLoader {

    private final String fileName;

    public DistanceMatrixLoader(String fileName) {
        this.fileName = fileName;
    }

    public DistanceMatrix load() throws FileNotFoundException, IOException {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);

            String header = bufferReader.readLine();
            String[] distanceTokens = header.split(";");
            int matrixSize = distanceTokens.length - 1;

            String[] locations = Arrays.copyOfRange(distanceTokens, 1, distanceTokens.length);
            double[][] distances = new double[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String line = bufferReader.readLine();
                //removes location from line leaving only distances
                line = line.substring(line.indexOf(";") + 1);
                String[] locationTokens = line.split(";");
                distances[i] = Arrays.stream(locationTokens)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
            }

            return new DistanceMatrix(locations, distances);
    }
}
