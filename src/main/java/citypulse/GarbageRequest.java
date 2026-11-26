package citypulse;

public class GarbageRequest {
    private int id;
    private String location;
    private String wasteType;
    private String status;

    public GarbageRequest(int id, String location, String wasteType) {
        this.id = id;
        this.location = location;
        this.wasteType = wasteType;
        this.status = "Pending";
    }

    public int getId() { return id; }
    public String getLocation() { return location; }
    public String getWasteType() { return wasteType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Garbage #" + id + " | " + location + " | " + wasteType + " | " + status;
    }
}
