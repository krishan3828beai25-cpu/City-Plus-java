package citypulse;

public class CityDashboardService {
    public void display(TrafficService traffic, WaterService water,
                        ElectricityService electricity, GarbageService garbage,
                        EmergencyService emergency, ComplaintService complaints) {
        System.out.println("\n========== CITYPULSE DASHBOARD ==========");
        System.out.println("Traffic records          : " + traffic.getAll().size());
        System.out.println("Water use (litres)       : " + water.getTotalConsumption());
        System.out.println("Electricity use (kWh)    : " + electricity.getTotalUnits());
        System.out.println("Garbage requests         : " + garbage.getAll().size());
        System.out.println("Emergency queue          : " + emergency.pendingCount());
        System.out.println("Citizen complaints       : " + complaints.getAll().size());
        System.out.println("=========================================");
    }
}
