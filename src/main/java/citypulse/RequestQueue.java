package citypulse;

import java.util.LinkedList;
import java.util.Queue;

// Demonstrates wait() and notifyAll() for producer-consumer coordination.
public class RequestQueue {
    private final Queue<String> queue = new LinkedList<>();

    public synchronized void addRequest(String request) {
        queue.add(request);
        notifyAll();
    }

    public synchronized String takeRequest() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }

    public synchronized int size() { return queue.size(); }
}
