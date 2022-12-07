

public class Attributes extends AbstractDescription{


    private static final String ATTUNIT = "µg/m3";
    private static final String DESO3 = "ozone content";
    private static final String DESSO2 = "sulfur dioxide content";
    private static final String DESNO2 = "nitrogen dioxide content";
    private static final String DESPM10 = "fine particles content";
    private static final String[] ATTTYPES = {"O3", "SO2", "NO2", "PM10"};
    private String attributeID;
    private String unit;

    public Attributes(String attID) throws IllegalArgumentException{
        this.unit = ATTUNIT;
        for (String s : ATTTYPES) {
            if(s.equalsIgnoreCase("O3") && attID.equalsIgnoreCase("O3")){
                this.attributeID = attID;
                setDescription(DESO3);
            }
            if(s.equalsIgnoreCase("SO2") && attID.equalsIgnoreCase("SO2")){
                this.attributeID = attID;
                setDescription(DESSO2);
            }
            if(s.equalsIgnoreCase("NO2")&& attID.equalsIgnoreCase("NO2")){
                this.attributeID = attID;
                setDescription(DESNO2);
            }
            if(s.equalsIgnoreCase("PM10")&& attID.equalsIgnoreCase("PM10")){
                this.attributeID = attID;
                setDescription(DESPM10);
            }
        }
        
        
    }

    public String getAttributeID(){
        return attributeID;
    }

    public String getUnit(){
        return unit;
    }

    public static void main(String[] args) {
        Attributes a = new Attributes("o3");
        Attributes b = new Attributes("SO2");
        Attributes c = new Attributes("no2");
        Attributes d = new Attributes("pm10");
        Attributes e = new Attributes("x");
        Attributes f = new Attributes("");

        System.out.println("this is a test");
        System.out.println(a.getAttributeID() + " " + a.getUnit() + " " + a.getDescription());
        System.out.println(b.getAttributeID() + " " + b.getUnit() + " " + b.getDescription());
        System.out.println(c.getAttributeID() + " " + c.getUnit() + " " + c.getDescription());
        System.out.println(d.getAttributeID() + " " + d.getUnit() + " " + d.getDescription());
        System.out.println("-----------------------------");
        System.out.println( e.getAttributeID() + " " + e.getUnit() + " " + e.getDescription());
        System.out.println( f.getAttributeID() + " " + f.getUnit() + " " + f.getDescription());
        System.out.println("End of test");
        
    }





    
}
