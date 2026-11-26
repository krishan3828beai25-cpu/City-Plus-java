# CityPulse – Smart City Resource Management System

A beginner-friendly Java 17 console prototype for a smart city. It demonstrates OOP, collections, a priority queue, threads, wait/notifyAll, JDBC, PreparedStatement, streams, generics, file handling and exception handling.

## Requirements
- JDK 17 or newer
- Maven 3.8+
- Internet on the first Maven run so Maven can download SQLite JDBC

## Run
Open a terminal in this project folder and run:

```bash
mvn clean compile
mvn exec:java
```

The SQLite database file `citypulse.db` is created in the project folder. Reports are exported to the `reports` folder.

## Suggested tutor demonstration
1. Add two traffic records, then view and update one.
2. Add water and electricity readings.
3. Register a garbage request and mark it collected.
4. Register two emergency vehicles with different priorities. Dispatch once to show that priority 5 is served before priority 2.
5. Register and close a citizen complaint.
6. Open the dashboard, generate a report and export files.
7. Explain that `TrafficMonitorThread` and `EmergencyMonitorThread` run in the background.

## Important prototype limitations
- This is a classroom simulation, not a live connection to city sensors, traffic lights, utility meters or emergency services.
- The department service lists are in memory. JDBC DAO classes demonstrate saving selected records to SQLite, but this first prototype does not reload every department's records from the database after restarting.
- Update/complete/close operations currently update the in-memory prototype. For a final production version, add matching database update methods and load methods.
- The traffic update menu changes the in-memory record; add a DAO update method if persistent updates are required.

## Main class map
- `CityPulseApp`: program entry point.
- `MainMenu`: user interface and menu actions.
- `*Service`: department business logic.
- `*DAO` and `DatabaseConnection`: JDBC persistence examples.
- `TrafficMonitorThread`, `EmergencyMonitorThread`, `RequestQueue`: concurrency examples.
- `FileManager`, `CSVManager`: file export/import helpers.
- `GenericRepository<T>`, `CityDataProcessor`: generics and Stream API examples.

## Before submission
Understand and test each menu option yourself. Add your own improvements, take screenshots of successful runs, and commit your own progress to GitHub. Follow your tutor's rules about AI assistance and disclose assistance if required.
