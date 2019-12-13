package coursework.vehicalrental.Vehicle;

public class MotorBike extends Vehicle {
    private int heightOfSeat;
    private String helmetType;

    public MotorBike(String plateNO, String make,int heightOfSeat,String helmetType) {
        super(plateNO, make);
        this.heightOfSeat=heightOfSeat;
        this.helmetType=helmetType;
    }

    public int getHeightOfSeat() {
        return heightOfSeat;
    }

    public void setHeightOfSeat(int heightOfSeat) {
        this.heightOfSeat = heightOfSeat;
    }

    public String getHelmetType() {
        return helmetType;
    }

    public void setHelmetType(String helmetType) {
        this.helmetType = helmetType;
    }
}
