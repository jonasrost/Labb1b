import java.awt.*;

public abstract class Truck extends Vehicle {


    /***
     * Constructor of the class
     * @param nrDoors the number of doors the truck has
     * @param enginePower represents the engine power of the truck
     * @param color the color of the truck
     * @param modelName the model of the truck
     */
    public Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

}
