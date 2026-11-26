package citypulse;

public class EfficiencyCalculator {
    // Simple illustrative score: more completed work and fewer pending emergencies improve score.
    public double calculate(int completedRequests, int totalRequests, int pendingEmergencies) {
        if (totalRequests <= 0) return 100.0;
        double completion = (completedRequests * 100.0) / totalRequests;
        double emergencyPenalty = Math.min(30, pendingEmergencies * 5);
        return Math.max(0, Math.min(100, completion - emergencyPenalty));
    }
}
