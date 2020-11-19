import java.awt.*;
import java.util.ArrayList;

public class ArticulatedLorry extends Truck {

    private Transporter<Car> parentTransporter;
    private boolean rampLifted;

    public ArticulatedLorry() {
        super(2, 800, Color.blue, "ArticulatedLorry");
        parentTransporter = new Transporter<>(this.getXCoordinate(), this.getYCoordinate());
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
        return parentTransporter.nrOfEntities();
    }


    private boolean checkDistanceFromCarOK(Car car) {
        double deltaX = Math.abs(this.getXCoordinate() - car.getXCoordinate());
        double deltaY = Math.abs(this.getYCoordinate() - car.getYCoordinate());
        double delta = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

        if(delta < 10)
            return true;
        return false;
    }


    public ArrayList<Car> getCarsOnLorry() {
        return parentTransporter.getTransportedEntities();
    }

    public void loadCarOnLorry(Car carToBeLoaded) {
        if (checkDistanceFromCarOK(carToBeLoaded) && !rampLifted && nrOfCarsLoaded() < 5) {
            carToBeLoaded.stopEngine();
            parentTransporter.addToTransport(carToBeLoaded);
            giveLoadedCarSamePosition(carToBeLoaded);
        }
    }


    private void moveCarAwayFromTransportAfterUnload(Car unloadedCar) {
        unloadedCar.setXCoordinate(this.getXCoordinate() - 2);
        unloadedCar.setYCoordinate(this.getYCoordinate() + 2);
    }


    public void unloadCarsFromLorry(int nrOfCarsToUnload) {
        if (!rampLifted) {
            for (int i = 0; i < nrOfCarsToUnload; i++) {
                Car unloadedCar = parentTransporter.removeFromTransport(getCarsOnLorry().size()-1);
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


    @Override
    public void move() {
        if (direction == NORTH)
            this.setYCoordinate(this.getYCoordinate() + getCurrentSpeed());
        else if (direction == EAST)
            this.setXCoordinate(this.getXCoordinate() + getCurrentSpeed());
        else if (direction == SOUTH)
            this.setYCoordinate(this.getYCoordinate() - getCurrentSpeed());
        else
            this.setXCoordinate(this.getXCoordinate() - getCurrentSpeed());


        for (Car loadedCar: parentTransporter.getTransportedEntities()) {
            loadedCar.changePosition(this.getXCoordinate(), this.getYCoordinate());
        }

        parentTransporter.moveTransporter(direction, getCurrentSpeed());

    }
}
