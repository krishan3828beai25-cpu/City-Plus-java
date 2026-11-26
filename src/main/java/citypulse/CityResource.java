package citypulse;

public abstract class CityResource {
    private int id;
    private String location;

    public CityResource(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() { return id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public abstract String getDetails();
}
