import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Attributes extends AbstractDescription {
    // Path for attritutetype.csv
    private static final String PATH = "lib\\AttributeType.csv";
    private String attributeID;
    private String unit;

    public Attributes(String attributeID) throws IOException {
        // Creates attributes objects from CSV file,
        // and sets the attributeID, unit and description.
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
                // If the attributeId is the same as the one in the CSV file, set the
                // attributeID, unit and description.
                if (attributeID.equalsIgnoreCase(firstElement)) {
                    this.attributeID = firstElement;
                    this.unit = secondElement;
                    setDescription(thirdElement);
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        in.close();

    }

    // Getter for attributeId
    public String getAttributeID() {
        return attributeID;
    }

    // Getter for unit
    public String getUnit() {
        return unit;
    }

}
