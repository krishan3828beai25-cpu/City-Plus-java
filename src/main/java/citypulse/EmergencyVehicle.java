package citypulse;

public class EmergencyVehicle implements Comparable<EmergencyVehicle> {
    private String vehicleNumber;
    private String type;
    private int priority;
    private String destination;

    public EmergencyVehicle(String vehicleNumber, String type, int priority, String destination) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.priority = priority;
        this.destination = destination;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public int getPriority() { return priority; }
    public String getDestination() { return destination; }

    @Override
    public int compareTo(EmergencyVehicle other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return vehicleNumber + " | " + type + " | Priority: " + priority + " | To: " + destination;
    }
}
