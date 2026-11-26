package citypulse;

import java.util.ArrayList;
import java.util.List;

public class TrafficService {
    private final List<TrafficRecord> records = new ArrayList<>();

    public void add(TrafficRecord record) { records.add(record); }
    public List<TrafficRecord> getAll() { return new ArrayList<>(records); }

    public boolean update(int id, int vehicles, String level) {
        for (TrafficRecord r : records) {
            if (r.getId() == id) {
                r.setVehicleCount(vehicles);
                r.setCongestionLevel(level);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return records.removeIf(r -> r.getId() == id);
    }
}
