package coursework.vehicalrental.Vehicle;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//creates a collection in the db
@Document(collection = "Vehicle")

//to identify the two subclasses
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type") //creates a type field
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = MotorBike.class, name = "motorbike")
})
//Vehicle is the Parent class
public abstract class Vehicle {
    @Id
    private String id;
    private String plateNO;
    private String make;

    //Constructor
    public Vehicle(String plateNO,String make){
        this.plateNO=plateNO;
        this.make=make;
    }

    public String getPlateNO() {
        return plateNO;
    }

    public void setPlateNO(String plateNO) {
        this.plateNO = plateNO;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
