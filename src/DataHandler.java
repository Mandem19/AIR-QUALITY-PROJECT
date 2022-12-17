import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {

    private static final String PATH = "lib\\10sens.csv";

    private static final Date New = null;

    private static List<Data> listOfDatas = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        /*
         * String exampleString = "2017-12-30T23:31:05.7830000";
         * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
         * 
         * // DateTimeFormatter format =
         * // DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
         * Date dt = New SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
         * System.out.println(dt);
         */

        List<Data> d = readDataFromCSV(PATH);
        System.out.println(d.size());
        System.out.println(getAirQualityForAttribute(d, "SO2"));
        System.out.println(getAirQualityForAttribute(d, "NO2"));
        System.out.println(getAirQualityForAttribute(d, "O3"));
        System.out.println(getAirQualityForAttribute(d, "PM10"));
        System.out.println();
        System.out.println(getAirQualityForSensor(d, "Sensor0"));
        System.out.println(getAirQualityForSensor(d, "Sensor1"));
        System.out.println(getAirQualityForSensor(d, "Sensor2"));
        System.out.println(getAirQualityForSensor(d, "Sensor3"));
        System.out.println(getAirQualityForSensor(d, "Sensor4"));
        System.out.println(getAirQualityForSensor(d, "Sensor5"));
        System.out.println(getAirQualityForSensor(d, "Sensor6"));
        System.out.println(getAirQualityForSensor(d, "Sensor7"));
        System.out.println(getAirQualityForSensor(d, "Sensor8"));
        System.out.println(getAirQualityForSensor(d, "Sensor9"));

    }

    private static List<Data> readDataFromCSV(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(PATH)), "utf-8"));
        try {
            String line;

            while ((line = in.readLine()) != null) {
                String[] rows = line.split(";");
                Data data = createData(rows);
                listOfDatas.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        System.out.println("lwn " + listOfDatas.size());
        return listOfDatas;
    }

    private static List<Data> filterBySensorId(List<Data> dataList, String sensorId) {
        return dataList.stream()
                .filter(d -> d.getSensorID().equalsIgnoreCase(sensorId))
                .collect(Collectors.toList());
    }

    private static String getAirQualityForSensor(List<Data> dataList, String sensorId) {
        List<Data> list = filterBySensorId(dataList, sensorId);
        HashMap<String, Double> x = new HashMap<>();
        HashMap<String, Integer> counter = new HashMap<>();

        for (Data data : list) {
            if (x.containsKey(data.getAttributeID())) {
                x.put(data.getAttributeID(), x.get(data.getAttributeID()) + data.getValue());
                counter.put(data.getAttributeID(), counter.get(data.getAttributeID()) + 1);
            } else {
                x.put(data.getAttributeID(), data.getValue());
                counter.put(data.getAttributeID(), 1);
            }
        }
        String result = "";
        for (String key : x.keySet()) {
            x.put(key, x.get(key) / counter.get(key));
            result += key + ": \t\t" + Math.round(x.get(key) * 1000.0) / 1000.0 + "   µg/m3" + "\n";
        }

        return sensorId + "\n" + result;
    }

    private static List<Data> filterByAttributeId(List<Data> dataList, String attributeId) {
        return dataList.stream()
                .filter(d -> d.getAttributeID().equalsIgnoreCase(attributeId))
                .collect(Collectors.toList());

    }

    private static String getAirQualityForAttribute(List<Data> dataList, String attributeID) {
        List<Data> list = filterByAttributeId(dataList, attributeID);
        HashMap<String, Double> x = new HashMap<>();
        HashMap<String, Integer> counter = new HashMap<>();
        for (Data data : list) {
            if (x.containsKey(counter.get(data.getAttributeID()))) {
                x.put(data.getAttributeID(), x.get(data.getAttributeID()) + data.getValue());
                counter.put(data.getAttributeID(), counter.get(data.getAttributeID()) + 1);
            } else {
                x.put(data.getAttributeID(), data.getValue());
                counter.put(data.getAttributeID(), 1);

            }
        }

        String results = "";
        for (String key : x.keySet()) {
            x.put(key, x.get(key) / counter.get(key));
            results += key + ": \t\t" + Math.round(x.get(key) * 1000.0) / 1000.0 + "µg/m3" + "\n";
        }

        return results;
    }

    /*
     * 1. On a given territory get the mean air quality at a given time
     * 2. On a given territory get the mean air quality on a given time span
     * 
     */

    private static Data createData(String[] metaData) {
        // DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd
        // HH:mm:ss.SSSSSSS");
        String timestamp = metaData[0];

        String sensorID = metaData[1];
        String attributeID = metaData[2];
        Double value = Double.parseDouble(metaData[3]);
        return new Data(timestamp, sensorID, attributeID, value);

    }

}
