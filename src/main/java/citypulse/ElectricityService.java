package citypulse;

import java.util.ArrayList;
import java.util.List;

public class ElectricityService {
    private final List<ElectricityRecord> records = new ArrayList<>();
    public void add(ElectricityRecord record) { records.add(record); }
    public List<ElectricityRecord> getAll() { return new ArrayList<>(records); }
    public double getTotalUnits() {
        return records.stream().mapToDouble(ElectricityRecord::getUnitsConsumed).sum();
    }
}
