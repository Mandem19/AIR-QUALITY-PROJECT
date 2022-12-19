public class SensorMean {
    private Sensors sensors;
    private Double mean;

    public SensorMean() {

    }

    public SensorMean(Sensors sensorID, Double mean) {
        this.sensors = sensorID;
        this.mean = mean;
    }

    public Sensors getSensor() {
        return sensors;
    }

    public Double getMean() {
        return mean;
    }

    @Override
    public String toString() {
        return "Sensor ID: " + sensors.getSensorID() + " Sensor Location: " + sensors.getLatitude() +
                " " + sensors.getLongtitude() + " Sensor Mean: " + Math.round(mean * 1000.0) / 1000.0 + " µg/m3";

    }

}
