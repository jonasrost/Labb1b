import java.util.ArrayList;

public class Transporter<TransportedEntity extends Transportable> {

    private ArrayList<TransportedEntity> transportedEntities;

    private double xCoord;
    private double yCoord;


    public Transporter(double x, double y) {
        transportedEntities = new ArrayList<>();
        this.xCoord = x;
        this.yCoord = y;
    }

    public int nrOfEntities() {
        return transportedEntities.size();
    }

    public ArrayList<TransportedEntity> getTransportedEntities() {
        return transportedEntities;
    }

    public <T extends TransportedEntity> void addToTransport(T entity) {
        transportedEntities.add(entity);
    }

    public TransportedEntity removeFromTransport(int indexToRemove) {
        TransportedEntity entity = transportedEntities.remove(indexToRemove);
        return entity;
    }


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