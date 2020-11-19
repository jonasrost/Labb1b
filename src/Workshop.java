import java.util.ArrayList;
/** Class that creates a workshop object that can load vehicles of a certain type. */
public class Workshop<VehicleType extends Vehicle> {
    private ArrayList<VehicleType> vehiclesInWorkshop;

    /**Constructor that creates a new ArrayList. */
    public Workshop() {
        vehiclesInWorkshop = new ArrayList<>();
    }
    /** Returns the amount of vehicles in the workshop*/
    public int nrOfVehiclesInWorkshop() {
        return vehiclesInWorkshop.size();
    }

    /** Method that checks if vehicle entered in parameter is already in the object.
     * @param <T>
     * @param vehicle */
    private <T extends VehicleType> boolean checkIfCarAlreadyInShop(T vehicle) {
        for (VehicleType t : vehiclesInWorkshop) {
            if (vehicle.equals(t))
                return true;
        }
        return false;
    }

    /** Method that adds the vehicle entered in parameter if it does not already exist in Workshop.
     * @param <T>
     * @param vehicle */
    public <T extends VehicleType> void putVehicleInWorkshop(T vehicle) {
        if (nrOfVehiclesInWorkshop() < 10 && !checkIfCarAlreadyInShop(vehicle))
            this.vehiclesInWorkshop.add(vehicle);
    }

    /** Removes vehicle entered in parameter if it exists in object.
     * @param <T>
     * @param vehicle */
    public <T extends VehicleType> void removeVehicleFromWorkshop(T vehicle) {
        this.vehiclesInWorkshop.remove(vehicle);
    }

}