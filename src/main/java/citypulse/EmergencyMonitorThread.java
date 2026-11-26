package citypulse;

public class EmergencyMonitorThread extends Thread {
    private final EmergencyService service;
    private volatile boolean running = true;

    public EmergencyMonitorThread(EmergencyService service) {
        this.service = service;
        setName("Emergency-Monitor");
        setDaemon(true);
    }

    public void stopMonitoring() { running = false; interrupt(); }

    @Override
    public void run() {
        while (running) {
            if (service.pendingCount() > 0) {
                System.out.println("[Alert] Emergency vehicles are waiting for dispatch.");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                if (!running) break;
            }
        }
    }
}
