import java.awt.*;
import java.util.ArrayList;

public class ArticulatedLorry extends Truck{
    private ArrayList<Car> loadedCars;
    private boolean rampLifted;

    public ArticulatedLorry() {
        super(2, 800, Color.blue, "ArticulatedLorry");
        loadedCars = new ArrayList<>();
        rampLifted = true;
    }


    public void setDownRamp() {
        if (getCurrentSpeed() == 0)
            this.rampLifted = false;
    }

    public void liftUpRamp() {
        this.rampLifted = true;
    }

    private void giveLoadedCarSamePosition(Car loadedCar) {
        loadedCar.setXCoordinate(this.getXCoordinate());
        loadedCar.setYCoordinate(this.getYCoordinate());
    }

    public int nrOfCarsLoaded() {
        return loadedCars.size();
    }

    private boolean checkDistanceFromCarOK(Car car) {
        double deltaX = Math.abs(this.getXCoordinate() - car.getXCoordinate());
        double deltaY = Math.abs(this.getYCoordinate() - car.getYCoordinate());
        double delta = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

        if(delta < 10)
            return true;
        return false;
    }

    public void loadCarOnTransport(Car carToBeLoaded) {
        if (checkDistanceFromCarOK(carToBeLoaded) && !rampLifted && nrOfCarsLoaded() < 5) {
            carToBeLoaded.stopEngine();
            this.loadedCars.add(carToBeLoaded);
            giveLoadedCarSamePosition(carToBeLoaded);
        }
    }

    private void moveCarAwayFromTransportAfterUnload(Car unloadedCar) {
        unloadedCar.setXCoordinate(this.getXCoordinate() - 2);
        unloadedCar.setYCoordinate(this.getYCoordinate() + 2);
    }

    public void unloadCarsFromTransport(int nrOfCarsToUnload) {
        if (!rampLifted) {
            for (int i = 0; i < nrOfCarsToUnload; i++) {
                Car unloadedCar = this.loadedCars.remove((loadedCars.size()-1));
                moveCarAwayFromTransportAfterUnload(unloadedCar);
            }
        }
    }

    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + 2 * amount, getEnginePower());
    }

    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - 30 * amount, 0);
    }
}
