import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sensors extends AbstractDescription {
    // Path for attritutetype.csv
    private static final String PATH = "lib\\SensorsData.csv";
    private String sensorID;
    private double latitude;
    private double longitude;

    // Creates sensors objects from CSV file,
    // and sets the attributes sensorID, latitude and longitude.
    public Sensors(String sensorID) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(PATH));
        try {

            String line;
            while ((line = in.readLine()) != null) {
                String[] vals = line.split(";");
                /*
                 * Creates an array of 3 substrings,
                 * creates an array with 3 elements
                 */
                // These three elements define the attributeID, unit and description
                String firstElement = vals[0];
                String secondElement = vals[1];
                String thirdElement = vals[2];
                // If the sensorId is the same as the one in the CSV file, set the
                // sensorID, latitude and longitude.
                if (sensorID.equalsIgnoreCase(firstElement)) {
                    this.sensorID = firstElement;
                    this.latitude = Double.parseDouble(secondElement);
                    this.longitude = Double.parseDouble(thirdElement);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        in.close();

    }

    // getter for sensorID
    public String getSensorID() {
        return sensorID;
    }

    // getter for latitude
    public double getLatitude() {
        return latitude;
    }

    // getter for longitude
    public double getLongtitude() {
        return longitude;
    }

}