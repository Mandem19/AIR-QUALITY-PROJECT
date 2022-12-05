import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {


    public static void main(String[] args) throws IOException {
        String file = "lib\\data_10sensors_1year.csv";
        BufferedReader reader = null;
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
        
        /* 
        finally{
            try {
                reader.close();
            } catch (IOException e) {
               
                e.printStackTrace();
            }

        }
        */
        reader.close();

    }



    
}
