import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataHandler {

    private static final String PATH =  "lib\\data_10sensors_1year.csv";

    //C:\Users\jerem\OneDrive\Skrivbord\SoeJavaProject\AIR-QUALITY-PROJECT\lib\data_10sensors_1year.csv
    //"lib\\data_10sensors_1year.csv"
    //C:\\Users\\jerem\\OneDrive\\Skrivbord\\SoeJavaProject\\AIR-QUALITY-PROJECT\\lib\\data_10sensors_1year.csv
    private static List<Data> listOfDatas = new ArrayList<>();


    public static void main(String[] args) throws IOException{
        

        List<Data> datas = readDataFromCSV(PATH);
            
        for (Data d: datas){
            System.out.println(d.toString());
        }

 
        
 /* 
 for (int i = 0; i <= datas.size() - 1; i++){
            System.out.println(datas.get(i).toString());
        }
  * 
  */
        
        
    }


    private static List<Data> readDataFromCSV(String fileName) throws IOException{
       
        BufferedReader in = new BufferedReader(new FileReader(PATH));

        try {
            String line; 

            while((line = in.readLine()) != null){
                String [] rows = line.split(";");
                Data data = createData(rows);
                listOfDatas.add(data);
               

                /*
                 * for(String index: row){
                    System.out.print(index);
                   // System.out.printf("%-10s", index);
                }
                 */
                

                 
                
                return listOfDatas;
            
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();
        return null;
    }


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