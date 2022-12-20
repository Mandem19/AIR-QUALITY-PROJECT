public class SensorMean {
    private Sensors sensors;
    private Double mean;

    // Creates SensorMean object with sensorID and mean

    public SensorMean() {
    }

    public SensorMean(Sensors sensorID, Double mean) {
        this.sensors = sensorID;
        this.mean = mean;
    }

    // Getter for sensor object
    public Sensors getSensor() {
        return sensors;
    }

    // Getter for mean
    public Double getMean() {
        return mean;
    }

    // To string for SensorMean objects, to print out the values accordingly.
    @Override
    public String toString() {
        return "Sensor ID: " + sensors.getSensorID() + " Sensor Location: " + sensors.getLatitude() +
                " " + sensors.getLongtitude() + " Sensor Mean: " + Math.round(mean * 1000.0) / 1000.0 + " µg/m3";

    }

}
