public class Car extends Vehicle{
    private int noOfSeats;
    private boolean airConditioning;

    public Car(String type, String plateNO, String make,int noOfSeats,boolean airConditioning) {
        super(type,plateNO, make);
        this.noOfSeats=noOfSeats;
        this.airConditioning=airConditioning;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }
}

