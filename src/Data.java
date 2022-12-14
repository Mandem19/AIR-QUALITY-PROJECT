//import java.util.ArrayList;

public class Data {

    private String timestamp;
    private String sensorID;
    private String attributeID;
    private Double value; 
   // ArrayList<Data> dataList = new ArrayList<>();


   public Data(String timestamp, String sensorID, String attributeID, Double value) {
    this.timestamp = timestamp;
    this.sensorID = sensorID;
    this.attributeID = attributeID;
    this.value = value;

   // Data d = new Data(timestamp, sensorID, attributeID, value);
   // dataList.add(d);
}
    

public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
}


public void setSensorID(String sensorID) {
    this.sensorID = sensorID;
}


public void setAttributeID(String attributeID) {
    this.attributeID = attributeID;
}


public void setValue(Double value) {
    this.value = value;
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

    @Override
    public String toString() {
        return "Data [TimeStamp=" + timestamp + ", SensorID=" + sensorID + ", AttributeID=" + attributeID
                + ", Value=" + value + "]";
    }
         
    }





    

