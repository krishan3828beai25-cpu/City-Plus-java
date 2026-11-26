package citypulse;

import java.util.ArrayList;
import java.util.List;

public class GarbageService {
    private final List<GarbageRequest> requests = new ArrayList<>();
    public void add(GarbageRequest request) { requests.add(request); }
    public List<GarbageRequest> getAll() { return new ArrayList<>(requests); }

    public boolean markCollected(int id) {
        for (GarbageRequest r : requests) {
            if (r.getId() == id) {
                r.setStatus("Collected");
                return true;
            }
        }
        return false;
    }
}
