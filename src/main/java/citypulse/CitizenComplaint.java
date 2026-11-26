package citypulse;

public class CitizenComplaint {
    private int id;
    private String citizenName;
    private String category;
    private String description;
    private String status;

    public CitizenComplaint(int id, String citizenName, String category, String description) {
        this.id = id;
        this.citizenName = citizenName;
        this.category = category;
        this.description = description;
        this.status = "Open";
    }

    public int getId() { return id; }
    public String getCitizenName() { return citizenName; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Complaint #" + id + " | " + citizenName + " | " + category +
                " | " + description + " | " + status;
    }
}
