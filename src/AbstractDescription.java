abstract class AbstractDescription {

    private String description;

    public AbstractDescription(String s){
        this.description=s;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String newDescription){
        this.description=newDescription;
    }
    
}
