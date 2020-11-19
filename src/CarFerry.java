public class CarFerry {

    private Transporter<Car> parentTransporter;
    private double xCoordinate = 0;
    private double yCoordinate = 0;


    public CarFerry() {
        parentTransporter = new Transporter<>(xCoordinate,yCoordinate);
    }

    public int nrOfCarsLoaded() {
        return parentTransporter.nrOfEntities();
    }


    private void giveLoadedCarSamePosition(Car loadedCar) {
        loadedCar.setXCoordinate(this.xCoordinate);
        loadedCar.setYCoordinate(this.yCoordinate);
    }

    private boolean checkDistanceFromCarOK(Car car) {
        double deltaX = Math.abs(xCoordinate - car.getXCoordinate());
        double deltaY = Math.abs(yCoordinate - car.getYCoordinate());
        double delta = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

        if(delta < 10)
            return true;
        return false;
    }

    private void moveCarAwayFromFerryAfterUnload(Car unloadedCar) {
        unloadedCar.setXCoordinate(xCoordinate - 2);
        unloadedCar.setYCoordinate(yCoordinate + 2);
    }


    public void loadCarOnFerry(Car carToBeLoaded) {
        if (checkDistanceFromCarOK(carToBeLoaded) && nrOfCarsLoaded() < 15) {
            parentTransporter.addToTransport(carToBeLoaded);
            giveLoadedCarSamePosition(carToBeLoaded);
        }
    }


    public void unloadCarsFromFerry(int nrOfCarsToUnload) {

        for (int i = 0; i < nrOfCarsToUnload; i++) {
            Car unloadedCar = parentTransporter.removeFromTransport(0);
            moveCarAwayFromFerryAfterUnload(unloadedCar);
        }

    }
}
