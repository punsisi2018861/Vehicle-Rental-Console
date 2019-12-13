public abstract class Vehicle {
    private String type;
    private String plateNO;
    private String make;

    public Vehicle(String type,String plateNO,String make){
        this.type=type;
        this.plateNO=plateNO;
        this.make=make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}

