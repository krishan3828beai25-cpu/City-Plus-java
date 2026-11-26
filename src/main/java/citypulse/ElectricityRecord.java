package citypulse;

public class ElectricityRecord extends CityResource {
    private double unitsConsumed;

    public ElectricityRecord(int id, String location, double unitsConsumed) {
        super(id, location);
        this.unitsConsumed = unitsConsumed;
    }

    public double getUnitsConsumed() { return unitsConsumed; }
    public void setUnitsConsumed(double value) { unitsConsumed = value; }

    @Override
    public String getDetails() {
        return "Electricity #" + getId() + " | " + getLocation() +
                " | Units: " + unitsConsumed + " kWh";
    }
}
