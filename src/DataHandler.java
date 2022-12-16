import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {

    private static final String PATH = "lib\\10sens.csv";

    private static List<Data> listOfDatas = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        List<Data> dataListX = readDataFromCSV(PATH);
        List<Data> dataListWithSensorId = filterBySensorId(dataListX, "Sensor7");
        for (Data data : dataListWithSensorId) {
            System.out.println(data.toString());
        }

        String a = getMeanSensor(filterBySensorId(readDataFromCSV(PATH), "Sensor7"), "Sensor7");
        System.out.print(a);
        String c = getMeanSensor(filterBySensorId(readDataFromCSV(PATH), "Sensor9"), "Sensor9");
        System.out.print(c);
        String b = getMeanSensor(filterBySensorId(readDataFromCSV(PATH), "Sensor"), "Sensor");
        System.out.print(b);

    }

    private static List<Data> readDataFromCSV(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File(PATH)), "utf-8"));
        try {
            String line;

            while ((line = in.readLine()) != null) {
                String[] rows = line.split(";");
                Data data = createData(rows);
                listOfDatas.add(data);
                line = in.readLine();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

        return listOfDatas;
    }

    /*
     * 3. Find the values that characterise air quality at a given place, GET all
     * the values at a given place, eg for sensor0, get all measurments
     * 
     * For all sensorX get all the values ex attributeX, attributeY
     * Give the mean airquality of that for each attributeX or Y etc
     */

    private static List<Data> filterBySensorId(List<Data> dataList, String sensorId) {
        return dataList.stream()
                .filter(d -> d.getSensorID().equalsIgnoreCase(sensorId))
                .collect(Collectors.toList());
    }

    private static String getMeanSensor(List<Data> dataList, String sensorId) {
        List<Data> list = filterBySensorId(dataList, sensorId);
        int counter = 0;
        String a = "";
        Double aa = 0.0;
        String b = "";
        Double bb = 0.0;
        String c = "";
        Double cc = 0.0;
        String d = "";
        Double dd = 0.0;
        for (Data data : list) {
            if (data.getAttributeID().equalsIgnoreCase("O3")) {
                aa += data.getValue();
            }
            if (data.getAttributeID().equalsIgnoreCase("SO2")) {
                bb += data.getValue();
            }
            if (data.getAttributeID().equalsIgnoreCase("NO2")) {
                cc += data.getValue();
            }
            if (data.getAttributeID().equalsIgnoreCase("PM10")) {
                dd += data.getValue();
            }
            counter++;
        }

        return "Air quality measurements for sensor: " + sensorId + "\n" +
                "O3: " + (aa / counter) + "\n" +
                "SO2: " + (bb / counter) + "\n" +
                "NO2 " + (cc / counter) + "\n" +
                "PM10 " + (dd / counter) + "\n";
    }

    private static Data createData(String[] metaData) {
        String timestamp = metaData[0];
        String sensorID = metaData[1];
        String attributeID = metaData[2];
        Double value = Double.parseDouble(metaData[3]);
        return new Data(timestamp, sensorID, attributeID, value);
    }

}
