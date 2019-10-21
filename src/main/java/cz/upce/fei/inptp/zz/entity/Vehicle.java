package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

public class Vehicle {

    private final String identifier;

    private final int capacity;

    private final VehicleType type;

    // TODO:initial position?

    /**
     * 
     * @param capacity has to be a positive number.
     */
    public Vehicle(String identifier, int capacity, VehicleType type) {
        this.identifier = Objects.requireNonNull(identifier, "id should not be null!");
        if (capacity <= 0) {
            String errorMessage = "Capacity should be non-zero and positive number. Received " + capacity;
            throw new IllegalArgumentException(errorMessage);
        }
        this.capacity = capacity;
        this.type = Objects.requireNonNull(type, "type should not be null!");
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public VehicleType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }
    
    
}
