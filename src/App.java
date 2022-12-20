import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    // Path to csv file for all the data
    private static final String PATH = "lib\\1Year.csv";

    public static void main(String[] args) throws IOException {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);
        // Read data from csv file
        List<Data> allData = DataHandler.readDataFromCSV(PATH);
        System.out.println("Welcome, choose one of the following options, enter (1-3)");
        System.out.println("1. Get the air quality for a given territory on a given time span");
        System.out.println("2. Get the air quality for a given territory");
        System.out.println("3. Get the air quality for different territories with the same air quality ID");

        int choice = scanner.nextInt();
        // If user chooses 1 - get the air quality for a given territory on a given time
        // span
        if (choice == 1) {
            scanner = new Scanner(System.in);
            System.out.println("Setup things please wait...");
            List<Sensors> list = new ArrayList<>();
            // Create a list of sensors
            for (int i = 0; i < 10; i++) {
                Sensors s = new Sensors("sensor" + i);
                list.add(s);
            }

            // ask user for sensorID
            System.out.println("Enter sensorID: ");
            String sensorID = scanner.nextLine();

            // ask user for start date
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
            // Combine date and time to one string
            String startDateTime = startDate + "T" + startTime;
            String endDateTime = endDate + "T" + endTime;
            // Parse the string to LocalDateTime
            LocalDateTime start = LocalDateTime.parse(startDateTime);
            LocalDateTime end = LocalDateTime.parse(endDateTime);

            System.out.println("Getting data please wait...");
            // Get the mean for the given time span
            List<SensorMean> list2 = new ArrayList<>();
            for (Sensors s : list) {
                SensorMean sensorMean = new SensorMean(s, DataHandler.getMeanForTimeSpan(start, end, s.getSensorID()));
                list2.add(sensorMean);
            }
            // Get the mean for the given time span and sensorID
            double mean = DataHandler.getMeanForTimeSpan(start, end, sensorID);
            // Print out the mean and the other sensor means close to the given sensorID
            System.out.println(
                    "For sensor: " + sensorID + " the mean is:  " + "\n" + +Math.round(mean * 1000.0) / 1000.0
                            + " µg/m3");

            System.out.println("Other sensor means close to " + sensorID + " are: " + "\n");
            for (SensorMean s : list2) {
                System.out.println(s);
            }
            // If user chooses 2 - get the air quality for a given territory/Sensor
        } else if (choice == 2) {
            System.out.println("Enter sensorID, 0-9");
            // Ask user for sensorID
            String sensId = scanner.next();
            // Get the air quality for the given sensorID
            String result = DataHandler.getAirQualityForSensor(allData, sensId);
            // Print out the result for the given sensorID
            System.out.println("The result is: " + "\n" + result);
            // If user chooses 3 - get the air quality for different territories with the
            // same air quality ID
        } else if (choice == 3) {
            System.out.println("Enter air quality ID:" + "\n" + "SO2, O3, NO2, PM10:");
            // Ask user for air quality ID
            String attId = scanner.next();
            // Get the air quality for the given air quality ID
            String result = DataHandler.getAirQualityForAttribute(allData, attId);
            // Print out the result for the given air quality ID
            System.out.println("The result is: " + "\n" + result);
        } else {
            // If user enters invalid choice
            System.out.println("Invalid choice");
        }

    }

}
