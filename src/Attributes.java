import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Attributes extends AbstractDescription{

    private static final String PATH = "lib\\AttributeType.csv";
    private String attributeID;
    private String unit; 


    public Attributes(String attributeID) throws IOException{
       
        BufferedReader in = new BufferedReader(new FileReader(PATH));
        try {
            
            String line; 
            while((line = in.readLine()) != null){
                String [] vals = line.split(";");
                /*
                 * Creates an array of 3 substrings, 
                 * creates an array with 3 elements
                 */
                
                 String firstElement = vals[0];
                 String secondElement = vals[1];
                 String thirdElement = vals[2];

                 if (attributeID.equalsIgnoreCase(firstElement)){
                    this.attributeID=firstElement;
                 this.unit=secondElement;
                 setDescription(thirdElement);
                 }
                 
                /*
                 * Split the line at the comma so i have 2 numbers
                 * Parse them both as numbers
                 * create new object using those numbers
                 */

            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        in.close();
        
        
        
    }

    public String getAttributeID() {
        return attributeID;
    }

    public String getUnit() {
        return unit;
    }


    public static void main(String[] args) throws IOException {
        System.out.println("NEW TEST ");
        Attributes a = new Attributes("O3");
        Attributes b = new Attributes("SO2");
        Attributes c = new Attributes("NO2");
        Attributes d = new Attributes("PM10");

        Attributes e = new Attributes("");
        Attributes f = new Attributes("X");


        System.out.println(a.getAttributeID()+ " " + a.getUnit()+ " " + a.getDescription());
        System.out.println(b.getAttributeID()+ " " + b.getUnit()+ " " + b.getDescription());
        System.out.println(c.getAttributeID()+ " " + c.getUnit()+ " " + c.getDescription());
        System.out.println(d.getAttributeID()+ " " + d.getUnit()+ " " + d.getDescription());
        System.out.println("-------------------------------------------------------------");
        System.out.println(e.getAttributeID()+ " " + e.getUnit()+ " " + e.getDescription());
        System.out.println(f.getAttributeID()+ " " + f.getUnit()+ " " + f.getDescription());
    }
    
}
