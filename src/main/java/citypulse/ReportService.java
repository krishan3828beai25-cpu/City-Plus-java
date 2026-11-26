package citypulse;

public class ReportService {
    public CityReport generate(TrafficService traffic, WaterService water,
                               ElectricityService electricity, GarbageService garbage,
                               EmergencyService emergency, ComplaintService complaints) {
        String summary = "CITYPULSE CITY EFFICIENCY REPORT\n" +
                "Traffic records: " + traffic.getAll().size() + "\n" +
                "Water consumption: " + water.getTotalConsumption() + " litres\n" +
                "Electricity consumption: " + electricity.getTotalUnits() + " kWh\n" +
                "Garbage requests: " + garbage.getAll().size() + "\n" +
                "Pending emergency vehicles: " + emergency.pendingCount() + "\n" +
                "Citizen complaints: " + complaints.getAll().size() + "\n" +
                "Report time: " + DateTimeUtil.now();
        return new CityReport(summary);
    }
}
