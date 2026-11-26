package citypulse;

public class WaterRecord extends CityResource {
    private double consumptionLitres;

    public WaterRecord(int id, String location, double consumptionLitres) {
        super(id, location);
        this.consumptionLitres = consumptionLitres;
    }

    public double getConsumptionLitres() { return consumptionLitres; }
    public void setConsumptionLitres(double value) { consumptionLitres = value; }

    @Override
    public String getDetails() {
        return "Water #" + getId() + " | " + getLocation() +
                " | Consumption: " + consumptionLitres + " litres";
    }
}
