package citypulse;

import java.util.ArrayList;
import java.util.List;

public class WaterService {
    private final List<WaterRecord> records = new ArrayList<>();
    public void add(WaterRecord record) { records.add(record); }
    public List<WaterRecord> getAll() { return new ArrayList<>(records); }
    public double getTotalConsumption() {
        return records.stream().mapToDouble(WaterRecord::getConsumptionLitres).sum();
    }
}
