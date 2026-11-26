package citypulse;

public class TrafficRecord extends CityResource {
    private int vehicleCount;
    private String congestionLevel;

    public TrafficRecord(int id, String location, int vehicleCount, String congestionLevel) {
        super(id, location);
        this.vehicleCount = vehicleCount;
        this.congestionLevel = congestionLevel;
    }

    public int getVehicleCount() { return vehicleCount; }
    public String getCongestionLevel() { return congestionLevel; }
    public void setVehicleCount(int count) { vehicleCount = count; }
    public void setCongestionLevel(String level) { congestionLevel = level; }

    @Override
    public String getDetails() {
        return "Traffic #" + getId() + " | " + getLocation() +
                " | Vehicles: " + vehicleCount + " | Congestion: " + congestionLevel;
    }
}
