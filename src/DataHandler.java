import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {

    private static final String PATH =  "lib\\data_10sensors_1year.csv";
    private static List<Data> listOfDatas = new ArrayList<>();
    //private static List<Data> listOfDatasForSensor = new ArrayList<>();


    /*
     * 
     * This timestamp 
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     */


  

    public static void main(String[] args) throws IOException{
        
/*
 *  List<Data> dataList = readDataFromCSV(PATH);
 for (Data data : dataList) {
    System.out.println(data.toString());
 }
 */

 List<Data> list = getDataForSensor("Sensor0");
 for (Data data : list) {
    System.out.println(data.toString());
 }

}
 


 /*
  * List<Data> dataList = readDataFromCSV(PATH);
 //List<Data> dataListWithSensorId = filterBySensorId(dataList, "Sensor0");

        for (Data data : dataListWithSensorId) {
            System.out.print(data.toString());
        }
       
    }

  */
 
    private static List<Data> readDataFromCSV(String fileName) throws IOException{
       
        BufferedReader in = new BufferedReader(new FileReader(PATH));

        try {
            String line; 

            while((line = in.readLine()) != null){
                String [] rows = line.split(";");
                Data data = createData(rows);
                listOfDatas.add(data);
                line = in.readLine();
                
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            in.close();
        }
        
        return listOfDatas;
    }


    /*
     * 3. Find the values that characterise air quality at a given place, GET all the values at a given place, eg for sensor0, get all measurments 
     * 
     * For all sensorX get all the values ex attributeX, attributeY 
     * Give the mean airquality of that for each attributeX or Y etc
     */

     private static List<Data> getDataForSensor(String sensID) throws IOException{
        List<Data> allData = readDataFromCSV(PATH);
        List<Data> listForSensor = new ArrayList<>();

        for (Data data : allData) {
            if(data.getSensorID().equalsIgnoreCase(sensID)){
                listForSensor.add(data);
            }            
        }
        return listForSensor;
     }


        /*
         * 
         * return persons.stream()
                      .filter(p -> p.getNationality().equals(nationality))
                      .collect(Collectors.toList());
         */

        
       // List<Data> listOfDatasForSensor = new ArrayList<>();
        

        /*
         * for(Data d: allData){
            System.out.println(d.getSensorID());
            listOfDatas.add(d);
        }
         * 
         */

     

     /*
      *  public static List<Data> filterBySensorId(List<Data> dataList, String sensorId) {
        return dataList.stream()
                       .filter(d -> d.getSensorID().equalsIgnoreCase(sensorId))
                       .collect(Collectors.toList());
    }
      */

    



    private static Data createData(String [] metaData){
        String timestamp = metaData[0].replaceAll("��", "");
        String sensorID = metaData[1];
        String attributeID = metaData[2];
        Double value = Double.parseDouble(metaData[3].replaceAll("([^0-9](?=[0-9])|[^0-9](?=\\.))", ""));
        return new Data(timestamp, sensorID, attributeID, value);
    }
    
}






















/*
 * 
 * 
 * 
 *  private static final String PATH = "lib\\data_10sensors_1year.csv";
    private Data data;
    private ArrayList<Data> dataList;
    private static BufferedReader reader; 




    private static void putInData(Double v, Data d) throws IOException{
        String file = PATH;
        reader = null;
        String line = "";
    
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            while((line = reader.readLine()) != null){

                String[] row = line.split(";");
                String firstElement = row[0];
                String secondElement = row[1];
                String thirdElement = row[2];
                String fourthElement = row[3];
                Double x = Double.parseDouble(fourthElement);
                
                

                if(Double.compare(v, x) == 0){
                    d.setTimestamp(firstElement);
                    d.setSensorID(secondElement);
                    d.setAttributeID(thirdElement);
                    d.setValue(x);
                }
                
            }

            
        } catch (Exception e) {
            e.printStackTrace();
          
        }
        reader.close();
    }

    private static void printAllData() throws IOException{
        String file = PATH;
        reader = null;
        String line = "";


        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            while((line = reader.readLine()) != null){

                String[] row = line.split(";");

                for(String index: row){
                    System.out.printf("%-10s", index);
                }
                System.out.println();

            }

            
        } catch (Exception e) {
            e.printStackTrace();
          
        }
        reader.close();

    }


    public static void main(String[] args) throws IOException {
      // printAllData();

    }
 */