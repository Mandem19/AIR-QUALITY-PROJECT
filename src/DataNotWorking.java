import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataNotWorking {

    private static final String PATH = "lib\\data_10sensors_1year.csv";
    private String timestamp;
    private String sensorID; 
    private String attributeID;
    private Double value; 

   
    public DataNotWorking(Double value) throws IOException{

        BufferedReader in = new BufferedReader(new FileReader(PATH));
        try {
            String line;
            while((line = in.readLine()) != null){
                String[] vals = line.split(";");
                
                String firstElement = vals[0];
                String secondElement = vals[1];
                String thirdElement = vals[2];
                String fourthElement = vals[3];
                Double x = Double.parseDouble(fourthElement);
                
                

                if(Double.compare(value, x) == 0){
                   this.timestamp=firstElement;
                    this.sensorID=secondElement;
                    this.attributeID=thirdElement;
                    this.value=x;    
                }

            }

            
        } catch (Exception e) {

            e.printStackTrace();
        }
        in.close();


    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getSensorID() {
        return sensorID;
    }

    public String getAttributeID() {
        return attributeID;
    }

    public Double getValue() {
        return value;
    }



    public static void main(String[] args) throws IOException{
        DataNotWorking a = new DataNotWorking(0.93);
        DataNotWorking b = new DataNotWorking(0.0);
        DataNotWorking c = new DataNotWorking(17.8902017543936);
        DataNotWorking d = new DataNotWorking(44.5797973028766);
        DataNotWorking f = new DataNotWorking(172.798449176892);
        DataNotWorking e = new DataNotWorking(null);
       

        System.out.println("Wrong value test");
        System.out.println(a.getTimestamp() + " " + a.getSensorID() + " " + a.getAttributeID() + " " + a.getValue());
        System.out.println(b.getTimestamp() + " " + b.getSensorID()+ " " + b.getAttributeID() + " " + b.getValue());
        System.out.println("Until here --------------------");
        System.out.println("Correct Test");
        System.out.println(c.getTimestamp() + " " + c.getSensorID() + " " + c.getAttributeID() + " " + c.getValue());
        System.out.println(d.getTimestamp() + " " + d.getSensorID()+ " " + d.getAttributeID() + " " + d.getValue());
        System.out.println(f.getTimestamp() + " " + f.getSensorID()+ " " + f.getAttributeID() + " " + f.getValue());
        System.out.println("Until here ----------------");
        System.out.println("Null Test");
        System.out.println(e.getTimestamp() + " " + e.getSensorID()+ " " + e.getAttributeID() + " " + e.getValue());
        System.out.println("Until here ----------------");
       
        
    }


    
}
