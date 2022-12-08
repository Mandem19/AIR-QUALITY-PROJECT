import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sensors extends AbstractDescription{

/* 
    private static final String[] SENTYPES = {"Sensor0", "Sensor1", "Sensor2", "Sensor3", 
    "Sensor4", "Sensor5", "Sensor6", "Sensor7","Sensor8","Sensor9"};*/

    private static final String PATH = "lib\\SensorsData.csv";
    private String sensorID;
    private double latitude; 
    private double longitude; 


    public Sensors(String sensorID) throws IOException{
        
        BufferedReader in = new BufferedReader(new FileReader(PATH));
        try {
            //(filename = br.readLine()) !=null && filename.trim().length()>0
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

                 if (sensorID.equalsIgnoreCase(firstElement)){
                    this.sensorID=firstElement;
                    this.latitude=Double.parseDouble(secondElement);
                    this.longitude=Double.parseDouble(thirdElement);
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

    public String getSensorID() {
        return sensorID;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude(){
        return longitude;
    }


    public static void main(String[] args) throws IOException{
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
        Sensors x = new Sensors("Sensor10");
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
        System.out.println(x.getSensorID() + " " + x.getLatitude() + " " + x.getLongtitude());
        System.out.println(y.getSensorID() + " " + y.getLatitude() + " " + y.getLongtitude());

        
    }
/* 
    private String sensorID;
    private double latitude; 
    private double longitude; 
    private String description; 


    public Sensors(String sensID){
        if(sensID.equalsIgnoreCase("Sensor0")){
            this.sensorID="Sensor0";
            this.latitude=-8.15758888291083;
            this.longitude=-34.7692487876719;
        }
        if(sensID.equalsIgnoreCase("Sensor1")){
            this.sensorID="Sensor1";
            this.latitude=-30.0647387677174;
            this.longitude=-76.3439147576429;
        }

    }*/
    
}