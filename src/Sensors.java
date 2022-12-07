import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sensors extends AbstractDescription{

/* 
    private static final String[] SENTYPES = {"Sensor0", "Sensor1", "Sensor2", "Sensor3", 
    "Sensor4", "Sensor5", "Sensor6", "Sensor7","Sensor8","Sensor9"};*/

    private static final String PATH = "lib\\Sensors.csv";
    private String sensorID;
    private double latitude; 
    private double longitude; 



    public Sensors(String sensorID) throws IOException{
        
        BufferedReader in = new BufferedReader(new FileReader(PATH));
        try {
            //(filename = br.readLine()) !=null && filename.trim().length()>0
            String line; 
            while(((line = in.readLine()) != null) && (line.trim().length()>0)){
                String [] vals = line.split(";");
                /*
                 * Creates an array of 3 substrings, 
                 * creates an array with 3 elements
                 */
                
                 String firstElement = vals[0];
                 String secondElement = vals[1];
                 String thirdElement = vals[2];
                 String fourthElement = vals[3];

                 if (sensorID.equalsIgnoreCase(firstElement)){
                    this.sensorID=firstElement;
                    this.latitude=Double.parseDouble(secondElement);
                    this.longitude=Double.parseDouble(thirdElement);
                    setDescription(fourthElement);
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
        Sensors a = new Sensors("Sensors0");
        Sensors b = new Sensors("Sensors1");
        Sensors c = new Sensors("Sensors2");
        Sensors d = new Sensors("Sensors3");
        Sensors e = new Sensors("Sensors4");
        Sensors f = new Sensors("Sensors5");
        Sensors g = new Sensors("Sensors6");
        Sensors h = new Sensors("Sensors7");
        Sensors i = new Sensors("Sensors8");
        Sensors j = new Sensors("Sensors9");
        Sensors k = new Sensors("Sensors11");
        Sensors l = new Sensors("");

        System.out.println("This is a test: ");
        System.out.println(a.getSensorID() + " " + a.getLatitude() + " " + a.getLongtitude() + " " + a.getDescription());
        System.out.println(b.getSensorID() + " " + b.getLatitude() + " " + b.getLongtitude() + " " + b.getDescription());
        System.out.println(c.getSensorID() + " " + c.getLatitude() + " " + c.getLongtitude() + " " + c.getDescription());
        System.out.println(d.getSensorID() + " " + d.getLatitude() + " " + d.getLongtitude() + " " + d.getDescription());
        System.out.println(e.getSensorID() + " " + e.getLatitude() + " " + e.getLongtitude() + " " + e.getDescription());
        System.out.println(f.getSensorID() + " " + f.getLatitude() + " " + f.getLongtitude() + " " + f.getDescription());
        System.out.println(g.getSensorID() + " " + g.getLatitude() + " " + g.getLongtitude() + " " + g.getDescription());
        System.out.println(h.getSensorID() + " " + h.getLatitude() + " " + h.getLongtitude() + " " + h.getDescription());
        System.out.println(i.getSensorID() + " " + i.getLatitude() + " " + i.getLongtitude() + " " + i.getDescription());
        System.out.println(j.getSensorID() + " " + j.getLatitude() + " " + j.getLongtitude() + " " + j.getDescription());
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(k.getSensorID() + " " + k.getLatitude() + " " + k.getLongtitude() + " " + k.getDescription());
        System.out.println(l.getSensorID() + " " + l.getLatitude() + " " + l.getLongtitude() + " " + l.getDescription());




        
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
