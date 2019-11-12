/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SteproCZ
 */
public class PlanItemPriceCalculatorTest {
    
    /**
     * Test of calculatePrice method, of class PlanItemPriceCalculator.
     */
    
    private PlanItemPriceCalculator preparePlanItemPriceCalculator() {
        String[] locations = {"A", "B", "C", "D"};
        double[][] distances = {
            {0, 1, 2, 3},
            {1, 0, 4, 5},
            {2, 4, 0, 6},
            {3, 5, 6, 0}
        };

        return new PlanItemPriceCalculator(new DistanceMatrix(locations, distances));
    }
    
    @Test
    public void testCalculatePriceEmptyOrders() {     
        PlanItemPriceCalculator planItemPriceCalculator = preparePlanItemPriceCalculator();
        Vehicle vehicle = new Vehicle("id", 4, VehicleType.Small,6);
        Driver driver = new Driver("driver");
        PlanItem planItem = new PlanItem(vehicle, driver);
        
        double price = planItemPriceCalculator.calculatePrice(planItem);
        assertEquals(0, price, 0.01);
    }
    
    @Test
    public void testCalculatePrice1() {     
        PlanItemPriceCalculator planItemPriceCalculator = preparePlanItemPriceCalculator();
        Vehicle vehicle = new Vehicle("id", 4, VehicleType.Small,6);
        Driver driver = new Driver("driver");
        PlanItem planItem = new PlanItem(vehicle, driver);
        planItem.addOrder(new Order("A", "C", 2));
        
        double price = planItemPriceCalculator.calculatePrice(planItem);
        assertEquals(12, price, 0.01);
    }
    
}
