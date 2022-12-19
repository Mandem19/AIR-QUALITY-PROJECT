import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String PATH = "lib\\1Year.csv";

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        List<Data> allData = DataHandler.readDataFromCSV(PATH);
        System.out.println("Welcome, choose one of the following options, enter (1-3)");
        System.out.println("1. Get the air quality for a given territory on a given time span");
        System.out.println("2. Get the air quality for a given territory");
        System.out.println("3. Get the air quality for different territories with the same air quality ID");

        int choice = scanner.nextInt();
        if (choice == 1) {
            scanner = new Scanner(System.in);
            System.out.println("Setup things please wait...!!!");
            List<Sensors> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Sensors s = new Sensors("sensor" + i);
                list.add(s);
            }

            // ask user for sensorID
            System.out.println("Enter sensorID: ");
            String sensorID = scanner.nextLine();

            // ask user for start date (2017-01-01)
            System.out.println("Enter start date (YYYY-MM-DD): ");
            String startDate = scanner.nextLine();

            // ask user for end date
            System.out.println("Enter end date (YYYY-MM-DD): ");
            String endDate = scanner.nextLine();

            // ask user for start time
            System.out.println("Enter start time (HH:mm:ss): ");
            String startTime = scanner.nextLine();

            // ask user for end time
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
            // Math.round(mean * 1000.0) / 1000.0
            System.out.println(
                    "For sensor: " + sensorID + " the mean is: " + Math.round(mean * 1000.0) / 1000.0 + " µg/m3");

            System.out.println("Other sensor means close to " + sensorID + " are: ");
            for (SensorMean s : list2) {
                System.out.println(s);
            }
        } else if (choice == 2) {
            System.out.println("Enter sensorID, 0-9");
            String sensId = scanner.next();
            String result = DataHandler.getAirQualityForSensor(allData, sensId);
            System.out.println("The result is: " + "\n" + result);
        } else if (choice == 3) {
            System.out.println("Enter air quality ID, SO2, O3, NO2, PM10:");
            String attId = scanner.next();
            String result = DataHandler.getAirQualityForAttribute(allData, attId);
            System.out.println("The result is: " + "\n" + result);
        } else {
            System.out.println("Invalid choice");
        }

    }

}
