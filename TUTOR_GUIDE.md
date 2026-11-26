# CityPulse – Tutor Explanation and Demo Script

## 30-second introduction
"CityPulse is a Java-based Smart City Resource Management System. It brings traffic, water, electricity, garbage collection, citizen complaints and emergency response into one console application. The current version is a simulation using sample information rather than live city sensors."

## Explain the flow
1. `CityPulseApp` starts the program.
2. `MainMenu` accepts the administrator's choice.
3. A department service performs the operation.
4. Model objects store the data.
5. DAO classes use JDBC and PreparedStatement to save selected data in SQLite.
6. Reports can be exported as text and CSV files.

## Explain Java concepts with examples
- **Encapsulation:** model classes keep fields private and expose getters/setters.
- **Inheritance:** `TrafficRecord`, `WaterRecord` and `ElectricityRecord` extend `CityResource`.
- **Polymorphism:** each resource implements `getDetails()` differently.
- **ArrayList:** department services keep records in lists.
- **PriorityQueue:** `EmergencyService` dispatches the highest priority vehicle first.
- **Multithreading:** traffic and emergency monitor threads run separately from the menu.
- **wait/notifyAll:** `RequestQueue` waits when there are no requests and notifies waiting consumers when a request arrives.
- **JDBC:** DAO classes use `Connection` and `PreparedStatement`.
- **Lambda/Streams:** `CityDataProcessor` filters and sorts traffic records; services sum utility consumption with streams.
- **Generics:** `GenericRepository<T>` can store objects of different types safely.
- **File handling:** `FileManager` writes a report and `CSVManager` exports summary data.
- **Exception handling:** input validation and try/catch prevent common input and database errors.

## Suggested live demonstration
1. Choose option 1; add a traffic record for "Main Market", 120 vehicles, High.
2. Choose option 2 to show the record.
3. Choose option 4; add water use for "Sector 5", 2500 litres.
4. Choose option 5; add electricity use for "Sector 5", 760 kWh.
5. Choose option 6; create a garbage request for "Bus Stand", "Household".
6. Choose option 8; mark that request collected.
7. Choose option 9 twice; add an ambulance with priority 5 and a police vehicle with priority 3.
8. Choose option 10; the ambulance should be dispatched first.
9. Choose option 11; add a citizen complaint.
10. Choose option 14 for dashboard, option 15 for report, and option 16 for export.

## Likely tutor questions
**Q: Why did you use a PriorityQueue?**  
A: Emergency requests should be handled by priority. The queue returns the highest-priority vehicle first.

**Q: Why use threads?**  
A: Background monitoring can continue while the administrator uses the menu.

**Q: What is JDBC?**  
A: Java Database Connectivity. It lets Java communicate with a database using SQL.

**Q: Why PreparedStatement?**  
A: It binds values separately from SQL text, helps avoid SQL injection, and handles values safely.

**Q: Is this connected to real city sensors?**  
A: No. It is a classroom simulation. Real sensors and department APIs would be future extensions.

**Q: Does all data persist after restart?**  
A: Selected inserts are saved to SQLite. The current service lists are in memory, so full reload and persistent update/delete operations are future improvements.
