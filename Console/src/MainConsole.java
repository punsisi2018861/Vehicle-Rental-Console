import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;



public class MainConsole {
    private static Scanner sc1=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("--------------------WELCOME-------------------");
        display();
    }

    //Display messages to the manager
    public static void display(){
        Scanner sc = new Scanner(System.in);

        System.out.println("PLease enter a Number to proceed");
        System.out.println("1.Add Vehicle");
        System.out.println("2.Delete Vehicle");
        System.out.println("3.View Vehicles");
        System.out.println("4.Search Vehicle by ID");
        System.out.println("6.Write details to file");
        System.out.println("5.Quit");
        System.out.print(">>>>");
        int userInput = sc.nextInt();

        //main functions of the manager
        switch (userInput) {
            case 1:{
                addVehicles();
                break;
            }
            case 2:{
                deleteVehicles();
                break;
            }
            case 3:
                try {
                    viewVehicles();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case 4:{
                searchVehicles();
                break;
            }
            case 6:{
                writeVehiclestoFile();
                break;
            }
            //Exits the program
            case 5:
                System.out.println("----------------GoodBye!----------------");
                return;
            default:
                System.out.println("-----------------Enter a valid number------------------\n");
        }
        //displays the same message until the manager exit the progarm
        display();
    }

    //method to delete vehicles in the system from the ID
    private static void deleteVehicles() {
        System.out.print("Enter the ID of the vehicle-");
        String id=getStringInput();
        try {
            WestminsterRentalVehicleManager.deleteVehicles(id);
            System.out.println("***************Successfully deleted one record!*****************\n");
        } catch (ConnectException e){
            System.out.println("***************There's a problem with your connection, please check if your server is up and running******************\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //View vehicles through hhtp Request
    public static void viewVehicles() throws IOException {
        try {
            String vehicles = WestminsterRentalVehicleManager.viewVehicle();
            String[] arr1=vehicles.split("}");
            for(String w:arr1){
                System.out.println(w);
            }
            System.out.println("No Of Vehicles-"+(arr1.length-1));
            System.out.println("No of slots available-"+(51-arr1.length));
        }
        catch (ConnectException e){
            System.out.println("***************There's a problem with your connection, please check if your server is up and running******************\n");
        }
    }

    //Write vehicle data to a file
    public static void writeVehiclestoFile(){
        try {
            String result=WestminsterRentalVehicleManager.viewVehicle();
            FileWriter fileWriter=new FileWriter("data.txt");
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
            System.out.println("**************Vehicles have been written to the data text file*****************\n");
        } catch (ConnectException e){
            System.out.println("***************There's a problem with your connection, please check if your server is up and running******************\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to add vehicles to the system
    public static void addVehicles(){
        String vehicles = null;
        try {
            vehicles = WestminsterRentalVehicleManager.viewVehicle();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr1=vehicles.split("}");
        if((arr1.length-1)<=50){
            Scanner sc1=new Scanner(System.in);
            System.out.println("--------Enter a number to proceed------------");
            System.out.println("1.Add a Car");
            System.out.println("2.Add a Motorbike");
            System.out.println("3.Go Back");
            System.out.print(">>>>");
            try{
                int vehicleChoice=sc1.nextInt();

                System.out.print("Enter the Vehicle Plate Number- ");
                String plateNO=getStringInput();
                System.out.print("Enter the Make of the Vehicle-");
                String make=getStringInput();

                switch (vehicleChoice){
                    //Adding a car
                    case 1:{
                        String type="car";
                        System.out.print("Enter the number of seats-");
                        int noOfSeats=sc1.nextInt();
                        System.out.print("Air Conditioning (True/False)-");
                        boolean airConditioning=sc1.nextBoolean();

                        Car vehicleCar= new Car(type,plateNO,make,noOfSeats,airConditioning);
                        // System.out.println(vehicleCar.getType());
                        WestminsterRentalVehicleManager.addCar(vehicleCar);
                        break;
                    }

                    case 2:{
                        //Adding a Motor Bike
                        String type="motorbike";
                        System.out.print("Enter the height of the seat- ");
                        int heightOfSeat=sc1.nextInt();
                        System.out.print("Enter the helmet type- ");
                        String helmetType=getStringInput();

                        MotorBike vehicleMotorBike=new MotorBike(type,plateNO,make,heightOfSeat,helmetType);
                        WestminsterRentalVehicleManager.addMotorBike(vehicleMotorBike);
                        break;
                    }

                    case 3:{
                        // display();
                    }

                    default:{
                        System.out.println("***************You entered a wrong number, Try again***************\n");
                    }

                }
            }
            catch (InputMismatchException e){
                System.err.println("*****************Please enter a Valid Input*******************\n");
            }
        }
        else{
            System.out.println("**********You've reached the maximum slots, PLease delete a vehicle to add another!***********");
        }

    }

    //method to search the vehicle from the vehicle ID
    public static void searchVehicles(){
        System.out.print("Please enter the ID of the vehicle-");
        String id= getStringInput();
        try {
            String vehicles=WestminsterRentalVehicleManager.searchVehicles(id);
            if(vehicles.equals("null")){
                System.out.println("*********************Please Enter a valid ID (You may view the vehicles, copy paste the ID)*********************\n");
            }
            else {
                System.out.println(vehicles);
            }
        }
        catch (ConnectException e){
            System.out.println("***************There's a problem with your connection, please check if your server is up and running******************\n");
        }
        catch (SocketTimeoutException e){
            System.out.println("*****************Please View the vehicles, copy the ID Search*****************\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to get multiple string inputs in multiple lines
    private static String getStringInput() {
        String line = sc1.nextLine();
        if (line != null && !line.isEmpty())
            return line;
        return getStringInput();
    }


}
