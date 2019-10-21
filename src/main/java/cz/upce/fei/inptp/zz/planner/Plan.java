package cz.upce.fei.inptp.zz.planner;

import cz.upce.fei.inptp.zz.entity.Driver;
import cz.upce.fei.inptp.zz.entity.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    
    private List<PlanItem> plan;

    public Plan() {
        plan = new ArrayList<>();
    }

    public List<PlanItem> getPlan() {
        return plan;
    }
    
    public PlanItem addNewVehiclePlan(Vehicle vehicle, Driver driver) {
        PlanItem newplan = new PlanItem(vehicle, driver);
        
        for (PlanItem item : plan) {
            if(item.getDriver().equals(driver)
                    && item.getVehicle().equals(vehicle)){
                return newplan;
            }
        }
        plan.add(newplan);
                
        return newplan;
    }
}
