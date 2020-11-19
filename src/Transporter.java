import java.util.ArrayList;
/** A class that contains the functionality to transport object. Usually created as an instance variable in the objects
 * that want to be able to transport a certain {@code TransportedEntity} */
public class Transporter<TransportedEntity extends Transportable> {

    /** An arraylist that contains all the entities that are currently being "transported"*/
    private ArrayList<TransportedEntity> transportedEntities;
    /** An x-coordinate variable to create a position in a 2D-Coordinate system*/
    private double xCoord;
    /** An y-coordinate variable to create a position in a 2D-Coordinate system*/
    private double yCoord;

    /** Constructor that creates an arraylist to contain the transported objects and creates an position in a 2D-Coordinate system
     * based on the arguments
     * @param x
     * @param y */
    public Transporter(double x, double y) {
        transportedEntities = new ArrayList<>();
        this.xCoord = x;
        this.yCoord = y;
    }

    /** Returns the size of the arraylist in object*/
    public int nrOfEntities() {
        return transportedEntities.size();
    }
    /** returns the list that contains the objects being transported*/
    public ArrayList<TransportedEntity> getTransportedEntities() {
        return transportedEntities;
    }
    /** Method that adds an object to the arraylist with transported objects*/
    public <T extends TransportedEntity> void addToTransport(T entity) {
        transportedEntities.add(entity);
    }
    /** Method that removes an object in the arraylist with transported objects*/
    public TransportedEntity removeFromTransport(int indexToRemove) {
        TransportedEntity entity = transportedEntities.remove(indexToRemove);
        return entity;
    }

    /** Changes the position of the object in a 2D-Coordinate system based on the arguments.
     * @param direction
     * @param value
     * */
    public void moveTransporter(int direction, double value) {
        if (direction == 0)
            yCoord = yCoord + value;
        else if (direction == 1)
            xCoord = xCoord + value;
        else if (direction == 2)
            yCoord = yCoord - value;
        else
            xCoord = xCoord - value;
    }

}