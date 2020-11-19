import java.util.ArrayList;

public class Workshop<VehicleType extends Vehicle> {
    private ArrayList<VehicleType> vehiclesInWorkshop;

    public Workshop() {
        vehiclesInWorkshop = new ArrayList<>();
    }


    private <T extends VehicleType> boolean checkIfCarAlreadyInShop(T vehicle) {
        for (VehicleType t : vehiclesInWorkshop) {
            if (vehicle.equals(t))
                return true;
        }
        return false;
    }


    public <T extends VehicleType> void putVehicleInWorkshop(T vehicle) {
        if (vehiclesInWorkshop.size() < 10 && !checkIfCarAlreadyInShop(vehicle))
            this.vehiclesInWorkshop.add(vehicle);
    }


    public <T extends VehicleType> void removeVehicleFromWorkshop(T vehicle) {
        this.vehiclesInWorkshop.remove(vehicle);
    }

}