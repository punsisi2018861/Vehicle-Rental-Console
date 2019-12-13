package coursework.vehicalrental;

import coursework.vehicalrental.Schedule.Schedule;
import coursework.vehicalrental.Vehicle.Vehicle;
import javafx.scene.Scene;

import java.util.List;
import java.util.Optional;

public interface RentalVehicleManager {

    public void addVehicle(Vehicle vehicle);
    public void addSchedule(Schedule schedule);

    public List<Vehicle> viewVehicles();
    public List<Schedule> viewSchedule();


    public void deleteVehicle(String id);

    public Optional<Vehicle> getVehicleById(String id);
/*
    public void searchVehicle(Vehicle vehicle);
    */
}
