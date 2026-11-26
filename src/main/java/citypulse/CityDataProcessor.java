package citypulse;

import java.util.List;
import java.util.stream.Collectors;

public class CityDataProcessor {
    public List<TrafficRecord> highCongestion(List<TrafficRecord> records) {
        return records.stream()
                .filter(r -> r.getCongestionLevel().equalsIgnoreCase("High"))
                .sorted((a, b) -> Integer.compare(b.getVehicleCount(), a.getVehicleCount()))
                .collect(Collectors.toList());
    }

    public List<String> locations(List<TrafficRecord> records) {
        return records.stream().map(TrafficRecord::getLocation)
                .distinct().collect(Collectors.toList());
    }
}
