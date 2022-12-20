import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.*;

public class AppTest {
    private static final String PATH = "lib\\1Year.csv";

    @Test

    // Attributes test
    public void testAttributeId() throws IOException {
        System.out.println("NEW TEST ");
        Attributes a = new Attributes("O3");
        Attributes b = new Attributes("SO2");
        Attributes c = new Attributes("NO2");
        Attributes d = new Attributes("PM10");

        Attributes e = new Attributes("");
        Attributes f = new Attributes("X");

        System.out.println(a.getAttributeID() + " " + a.getUnit() + " " + a.getDescription());
        System.out.println(b.getAttributeID() + " " + b.getUnit() + " " + b.getDescription());
        System.out.println(c.getAttributeID() + " " + c.getUnit() + " " + c.getDescription());
        System.out.println(d.getAttributeID() + " " + d.getUnit() + " " + d.getDescription());
        System.out.println("-------------------------------------------------------------");
        System.out.println(e.getAttributeID() + " " + e.getUnit() + " " + e.getDescription());
        System.out.println(f.getAttributeID() + " " + f.getUnit() + " " + f.getDescription());

    }

    @Test
    // Sensors test
    public void testSensorId(String x) throws IOException {
        Sensors a = new Sensors("Sensor0");
        Sensors b = new Sensors("Sensor1");
        Sensors c = new Sensors("Sensor2");
        Sensors d = new Sensors("Sensor3");
        Sensors e = new Sensors("Sensor4");
        Sensors f = new Sensors("Sensor5");
        Sensors g = new Sensors("Sensor6");
        Sensors h = new Sensors("Sensor7");
        Sensors i = new Sensors("Sensor8");
        Sensors j = new Sensors("Sensor9");
        Sensors z = new Sensors("Sensor10");
        Sensors y = new Sensors("");

        System.out.println("This is a test: ");
        System.out.println(a.getSensorID() + " " + a.getLatitude() + " " + a.getLongtitude());
        System.out.println(b.getSensorID() + " " + b.getLatitude() + " " + b.getLongtitude());
        System.out.println(c.getSensorID() + " " + c.getLatitude() + " " + c.getLongtitude());
        System.out.println(d.getSensorID() + " " + d.getLatitude() + " " + d.getLongtitude());
        System.out.println(e.getSensorID() + " " + e.getLatitude() + " " + e.getLongtitude());
        System.out.println(f.getSensorID() + " " + f.getLatitude() + " " + f.getLongtitude());
        System.out.println(g.getSensorID() + " " + g.getLatitude() + " " + g.getLongtitude());
        System.out.println(h.getSensorID() + " " + h.getLatitude() + " " + h.getLongtitude());
        System.out.println(i.getSensorID() + " " + i.getLatitude() + " " + i.getLongtitude());
        System.out.println(j.getSensorID() + " " + j.getLatitude() + " " + j.getLongtitude());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(z.getSensorID() + " " + z.getLatitude() + " " + z.getLongtitude());
        System.out.println(y.getSensorID() + " " + y.getLatitude() + " " + y.getLongtitude());

    }

    // Get AQ for attributeID test
    @Test
    public void testGetAQForAttId() throws IOException {
        List<Data> d = DataHandler.readDataFromCSV(PATH);
        System.out.println(d.size());
        System.out.println(DataHandler.getAirQualityForAttribute(d, "SO2"));
        System.out.println(DataHandler.getAirQualityForAttribute(d, "NO2"));
        System.out.println(DataHandler.getAirQualityForAttribute(d, "O3"));
        System.out.println(DataHandler.getAirQualityForAttribute(d, "PM10"));
        System.out.println();

    }

    // Get AQ for sensorID test
    public void testGetAQForSensId() throws IOException {
        List<Data> d = DataHandler.readDataFromCSV(PATH);
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor0"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor1"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor2"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor3"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor4"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor5"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor6"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor7"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor8"));
        System.out.println(DataHandler.getAirQualityForSensor(d, "Sensor9"));
    }

    // Get all data test
    public void getAllData() throws IOException {
        List<Data> d = DataHandler.readDataFromCSV(PATH);
        System.out.println(d);
    }

    // Get AQ for time span test
    public void testGetAQForTimeSpan() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Setup things please wait...!!!");
        List<Sensors> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Sensors s = new Sensors("sensor" + i);
            list.add(s);
        }
        System.out.println("Enter sensorID: ");
        String sensorID = scanner.nextLine();

        System.out.println("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.println("Enter start time (HH:mm:ss): ");
        String startTime = scanner.nextLine();

        System.out.println("Enter end time (HH:mm:ss): ");
        String endTime = scanner.nextLine();

        String startDateTime = startDate + "T" + startTime;
        String endDateTime = endDate + "T" + endTime;

        LocalDateTime start = LocalDateTime.parse(startDateTime);
        LocalDateTime end = LocalDateTime.parse(endDateTime);

        System.out.println("Getting data please wait...!!!");

        List<SensorMean> list2 = new ArrayList<>();
        for (Sensors s : list) {
            SensorMean sensorMean = new SensorMean(s, DataHandler.getMeanForTimeSpan(start, end, s.getSensorID()));
            list2.add(sensorMean);
        }

        double mean = DataHandler.getMeanForTimeSpan(start, end, sensorID);
        System.out.println(
                "For sensor: " + sensorID + " the mean is: " + Math.round(mean * 1000.0) / 1000.0 + " µg/m3");

    }

}
