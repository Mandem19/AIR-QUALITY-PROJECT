/*
 * Created an abstract class which Sensors.java & Attributes.java extends from.
 * This class contains the description of the sensor and attribute.
 * Since both classes uses this, it makes sense to create an abstract class, 
 * even though the description of the current software doesn't require description 
 * neccesarily it is a good idea to have it in the abstract class for further development.
 */

abstract class AbstractDescription {

    protected String description;

    public AbstractDescription() {
        setDescription(description);
        ;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

}
