package citypulse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainMenu {
    private final InputHelper input = new InputHelper();
    private final TrafficService traffic = new TrafficService();
    private final WaterService water = new WaterService();
    private final ElectricityService electricity = new ElectricityService();
    private final GarbageService garbage = new GarbageService();
    private final EmergencyService emergency = new EmergencyService();
    private final ComplaintService complaints = new ComplaintService();
    private final ReportService reports = new ReportService();
    private final CityDashboardService dashboard = new CityDashboardService();
    private final TrafficMonitorThread trafficMonitor = new TrafficMonitorThread();
    private final EmergencyMonitorThread emergencyMonitor = new EmergencyMonitorThread(emergency);
    private int nextId = 1;

    public void start() {
        DatabaseConnection.initialize();
        trafficMonitor.start();
        emergencyMonitor.start();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = input.readInt("Enter choice: ");
            try {
                switch (choice) {
                    case 1 -> addTraffic();
                    case 2 -> showTraffic();
                    case 3 -> updateTraffic();
                    case 4 -> addWater();
                    case 5 -> addElectricity();
                    case 6 -> addGarbage();
                    case 7 -> showGarbage();
                    case 8 -> completeGarbage();
                    case 9 -> addEmergency();
                    case 10 -> dispatchEmergency();
                    case 11 -> addComplaint();
                    case 12 -> showComplaints();
                    case 13 -> closeComplaint();
                    case 14 -> dashboard.display(traffic, water, electricity, garbage, emergency, complaints);
                    case 15 -> generateReport();
                    case 16 -> exportReport();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid menu choice.");
                }
            } catch (Exception e) {
                new ExceptionHandler().showMessage(e);
            }
        }
        trafficMonitor.stopMonitoring();
        emergencyMonitor.stopMonitoring();
        System.out.println("Thank you for using CityPulse!");
    }

    private void showMenu() {
        System.out.println("\n========== CITYPULSE SMART CITY SYSTEM ==========");
        System.out.println("1. Add traffic record");
        System.out.println("2. View traffic records");
        System.out.println("3. Update traffic record");
        System.out.println("4. Add water consumption record");
        System.out.println("5. Add electricity consumption record");
        System.out.println("6. Add garbage collection request");
        System.out.println("7. View garbage requests");
        System.out.println("8. Mark garbage request collected");
        System.out.println("9. Register emergency vehicle");
        System.out.println("10. Dispatch highest-priority emergency");
        System.out.println("11. Register citizen complaint");
        System.out.println("12. View complaints");
        System.out.println("13. Close complaint");
        System.out.println("14. View city dashboard");
        System.out.println("15. Generate efficiency report");
        System.out.println("16. Export report to text file");
        System.out.println("0. Exit");
        System.out.println("=================================================");
    }

    private void addTraffic() throws SQLException {
        String location = input.readText("Road/location: ");
        int vehicles = input.readInt("Number of vehicles: ");
        String level = input.readText("Congestion (Low/Medium/High): ");
        TrafficRecord record = new TrafficRecord(nextId++, location, vehicles, level);
        traffic.add(record);
        new TrafficDAO().insert(record);
        System.out.println("Traffic record added.");
    }

    private void showTraffic() {
        printItems(traffic.getAll(), "No traffic records yet.");
    }

    private void updateTraffic() {
        int id = input.readInt("Traffic record ID: ");
        int vehicles = input.readInt("New vehicle count: ");
        String level = input.readText("New congestion level: ");
        System.out.println(traffic.update(id, vehicles, level) ? "Updated." : "Record not found.");
    }

    private void addWater() throws SQLException {
        String location = input.readText("Area: ");
        double amount = input.readDouble("Water consumption in litres: ");
        int id = nextId++;
        water.add(new WaterRecord(id, location, amount));
        new ResourceDAO().insert("WATER", id, location, amount);
        System.out.println("Water record added.");
    }

    private void addElectricity() throws SQLException {
        String location = input.readText("Area: ");
        double amount = input.readDouble("Electricity units (kWh): ");
        int id = nextId++;
        electricity.add(new ElectricityRecord(id, location, amount));
        new ResourceDAO().insert("ELECTRICITY", id, location, amount);
        System.out.println("Electricity record added.");
    }

    private void addGarbage() throws SQLException {
        String location = input.readText("Collection location: ");
        String type = input.readText("Waste type: ");
        int id = nextId++;
        GarbageRequest request = new GarbageRequest(id, location, type);
        garbage.add(request);
        new RequestDAO().insert(id, location, type, request.getStatus());
        System.out.println("Garbage request registered.");
    }

    private void showGarbage() {
        printItems(garbage.getAll(), "No garbage requests.");
    }

    private void completeGarbage() {
        int id = input.readInt("Garbage request ID: ");
        System.out.println(garbage.markCollected(id) ? "Marked as collected." : "Request not found.");
    }

    private void addEmergency() {
        String number = input.readText("Vehicle number: ");
        String type = input.readText("Vehicle type (Ambulance/Fire/Police): ");
        int priority = input.readInt("Priority (1 lowest - 5 highest): ");
        if (!ValidationUtil.isValidPriority(priority)) {
            System.out.println("Priority must be between 1 and 5.");
            return;
        }
        String destination = input.readText("Destination: ");
        emergency.add(new EmergencyVehicle(number, type, priority, destination));
        System.out.println("Emergency vehicle added to priority queue.");
    }

    private void dispatchEmergency() {
        EmergencyVehicle vehicle = emergency.dispatchNext();
        System.out.println(vehicle == null ? "No emergency vehicles waiting." :
                "Dispatching: " + vehicle);
    }

    private void addComplaint() {
        String name = input.readText("Citizen name: ");
        String category = input.readText("Complaint category: ");
        String description = input.readText("Description: ");
        complaints.add(new CitizenComplaint(nextId++, name, category, description));
        System.out.println("Complaint registered.");
    }

    private void showComplaints() {
        printItems(complaints.getAll(), "No complaints.");
    }

    private <T> void printItems(List<T> items, String emptyMessage) {
        if (items.isEmpty()) {
            System.out.println(emptyMessage);
            return;
        }
        items.forEach(System.out::println);
    }

    private void closeComplaint() {
        int id = input.readInt("Complaint ID: ");
        System.out.println(complaints.close(id) ? "Complaint closed." : "Complaint not found.");
    }

    private void generateReport() throws SQLException {
        CityReport report = reports.generate(traffic, water, electricity, garbage, emergency, complaints);
        System.out.println("\n" + report);
        new ReportDAO().insert(report);
    }

    private void exportReport() throws IOException {
        CityReport report = reports.generate(traffic, water, electricity, garbage, emergency, complaints);
        new FileManager().write("reports/latest-report.txt", report.toString());
        List<String> csv = List.of(
                "Department,Count",
                "Traffic," + traffic.getAll().size(),
                "Water records," + water.getAll().size(),
                "Electricity records," + electricity.getAll().size(),
                "Garbage requests," + garbage.getAll().size(),
                "Emergency queue," + emergency.pendingCount(),
                "Complaints," + complaints.getAll().size()
        );
        new CSVManager().exportLines("reports/summary.csv", csv);
        System.out.println("Files saved in the reports folder.");
    }
}
