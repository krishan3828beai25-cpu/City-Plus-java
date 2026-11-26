package citypulse;

import java.time.LocalDateTime;

public class CityReport {
    private String summary;
    private LocalDateTime generatedAt;

    public CityReport(String summary) {
        this.summary = summary;
        this.generatedAt = LocalDateTime.now();
    }

    public String getSummary() { return summary; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }

    @Override
    public String toString() {
        return "Generated: " + generatedAt + System.lineSeparator() + summary;
    }
}
