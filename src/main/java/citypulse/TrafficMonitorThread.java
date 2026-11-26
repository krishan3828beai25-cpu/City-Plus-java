package citypulse;

public class TrafficMonitorThread extends Thread {
    private volatile boolean running = true;

    public TrafficMonitorThread() {
        setName("Traffic-Monitor");
        setDaemon(true);
    }

    public void stopMonitoring() { running = false; interrupt(); }

    @Override
    public void run() {
        while (running) {
            System.out.println("[Background] Traffic monitoring service is active.");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                if (!running) break;
            }
        }
    }
}
