package citypulse;

import java.util.PriorityQueue;

public class EmergencyService {
    private final PriorityQueue<EmergencyVehicle> queue = new PriorityQueue<>();

    public void add(EmergencyVehicle vehicle) { queue.offer(vehicle); }
    public EmergencyVehicle dispatchNext() { return queue.poll(); }
    public int pendingCount() { return queue.size(); }
    public PriorityQueue<EmergencyVehicle> getQueueCopy() {
        return new PriorityQueue<>(queue);
    }
}
