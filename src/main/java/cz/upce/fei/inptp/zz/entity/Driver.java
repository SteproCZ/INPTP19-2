package cz.upce.fei.inptp.zz.entity;

import java.util.Objects;

public class Driver {
    private String identifier;

    public Driver(String identifier) {
        this.identifier = Objects.requireNonNull(identifier, "identifier should not be null!");
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Driver other = (Driver) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }

    
    
}
