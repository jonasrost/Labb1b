import java.util.ArrayList;

public class Workshop<VehicleType> {
    private ArrayList<VehicleType> vehiclesInWorkshop;

    public Workshop() {
        vehiclesInWorkshop = new ArrayList<>();
    }

    public void putVehicleInWorkshop(VehicleType vehicle) {
        if (this.vehiclesInWorkshop.size() < 13)
            this.vehiclesInWorkshop.add(vehicle);
    }

    public void removeVehicleFromWorkshop(VehicleType vehicle) {
        this.vehiclesInWorkshop.remove(vehicle);
    }

}
