package citypulse;

import java.util.ArrayList;
import java.util.List;

public class ComplaintService {
    private final List<CitizenComplaint> complaints = new ArrayList<>();
    public void add(CitizenComplaint complaint) { complaints.add(complaint); }
    public List<CitizenComplaint> getAll() { return new ArrayList<>(complaints); }

    public boolean close(int id) {
        for (CitizenComplaint c : complaints) {
            if (c.getId() == id) {
                c.setStatus("Closed");
                return true;
            }
        }
        return false;
    }
}
