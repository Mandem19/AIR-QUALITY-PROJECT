import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {
    // Path to csv file for all the data
    private static final String PATH = "lib\\1Year.csv";
    // List of all the data
    private static List<Data> listOfDatas = new ArrayList<>();

    // Creates data objects from CSV file,
    static List<Data> readDataFromCSV(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(PATH)), "utf-8"));
        try {
            String line;

            while ((line = in.readLine()) != null) {
                String[] rows = line.split(";");
                // Help method to create data objects accordingly
                Data data = createData(rows);
                listOfDatas.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        // Returns the list of all the data
        return listOfDatas;
    }

    // Help method for get AirQualityForSensor
    // Gets a list of measurments for a specific sensor
    private static List<Data> filterBySensorId(List<Data> dataList, String sensorId) {
        return dataList.stream()
                .filter(d -> d.getSensorID().equalsIgnoreCase(sensorId))
                .collect(Collectors.toList());
    }

    // Gets the average of all the measurments for a specific sensor
    static String getAirQualityForSensor(List<Data> dataList, String sensorId) {
        // Create a list using the help method
        List<Data> list = filterBySensorId(dataList, sensorId);
        // Create a hashmap to store the average of all the measurments for a specific
        // sensor
        HashMap<String, Double> x = new HashMap<>();
        // Create a hashmap to store the number of measurments for a specific sensor
        HashMap<String, Integer> counter = new HashMap<>();
        // Loop through the list and add the values to the hashmap
        for (Data data : list) {
            // If the hashmap contains the attributeID, add the value to the hashmap
            if (x.containsKey(data.getAttributeID())) {
                // Add the value to the hashmap and add 1 to the counter
                x.put(data.getAttributeID(), x.get(data.getAttributeID()) + data.getValue());
                counter.put(data.getAttributeID(), counter.get(data.getAttributeID()) + 1);
            } else {
                // If the hashmap does not contain the attributeID, add the value to the hashmap
                x.put(data.getAttributeID(), data.getValue());
                counter.put(data.getAttributeID(), 1);
            }
        }
        // Loop through the hashmap and divide the value with the number of measurments
        String result = "";
        for (String key : x.keySet()) {
            x.put(key, x.get(key) / counter.get(key));
            result += key + ": \t\t" + Math.round(x.get(key) * 1000.0) / 1000.0 + "   µg/m3" + "\n";
        }
        // return result;
        return sensorId + "\n" + result;
    }

    // help method for getAirQualityForAttribute
    // gets a list of measurments for a specific attribute
    private static List<Data> filterByAttributeId(List<Data> dataList, String attributeId) {
        return dataList.stream()
                .filter(d -> d.getAttributeID().equalsIgnoreCase(attributeId))
                .collect(Collectors.toList());

    }

    // Gets the average of all the measurments for a specific attribute
    static String getAirQualityForAttribute(List<Data> dataList, String attributeID) {
        // Create a list using the help method
        List<Data> list = filterByAttributeId(dataList, attributeID);
        // Create a hashmap to store the average of all the measurments for a specific
        // attributeId
        HashMap<String, Double> x = new HashMap<>();
        // Create a hashmap to store the number of measurments for a specific
        // attributeId
        HashMap<String, Integer> counter = new HashMap<>();
        // Loop through the list and add the values to the hashmap
        for (Data data : list) {
            // If the hashmap contains the sensorID, add the value to the hashmap
            if (x.containsKey(counter.get(data.getAttributeID()))) {
                // Add the value to the hashmap and add 1 to the counter
                x.put(data.getAttributeID(), x.get(data.getAttributeID()) + data.getValue());
                // Add the value to the hashmap and add 1 to the counter
                counter.put(data.getAttributeID(), counter.get(data.getAttributeID()) + 1);
                // If the hashmap does not contain the sensorID, add the value to the hashmap
            } else {
                x.put(data.getAttributeID(), data.getValue());
                counter.put(data.getAttributeID(), 1);

            }
        }
        // Loop through the hashmap and divide the value with the number of measurments
        String results = "";
        for (String key : x.keySet()) {
            x.put(key, x.get(key) / counter.get(key));
            results += key + ": \t\t" + Math.round(x.get(key) * 1000.0) / 1000.0 + " µg/m3" + "\n";
        }
        // return result;
        return results;
    }

    // Gets the average of all the measurments for a specific time span
    static double getMeanForTimeSpan(LocalDateTime start, LocalDateTime end, String sensorID)
            throws IOException {
        // Create a list of all the data
        List<Data> allData = readDataFromCSV(PATH);
        // Create a double to store the sum of all the measurments
        double sum = 0;
        // Loop through the list and add the values to the sum
        for (Data data : allData) {
            // Split the timestamp and get the date
            String currentDate = data.getTimestamp().split("\\.")[0];
            // Parse the date
            LocalDateTime current = LocalDateTime.parse(currentDate);
            // If the date is between the start and end date, add the value to the sum
            if (current.equals(start) || (current.isAfter(start) && current.isBefore(end))) {
                // If the sensorID is the same as the sensorID in the list, add the value to the
                // sum
                if (data.getSensorID().equalsIgnoreCase(sensorID)) {
                    // Add the value to the sum
                    sum += data.getValue();
                }
            }
        }
        // Return the sum
        return sum;
    }

    // Help method for ReadDataFromCSV() to create Data objects
    private static Data createData(String[] metaData) {
        String timestamp = metaData[0];
        String sensorID = metaData[1];
        String attributeID = metaData[2];
        Double value = Double.parseDouble(metaData[3]);
        return new Data(timestamp, sensorID, attributeID, value);

    }

}
