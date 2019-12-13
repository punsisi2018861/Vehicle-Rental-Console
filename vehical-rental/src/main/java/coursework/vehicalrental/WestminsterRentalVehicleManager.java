package coursework.vehicalrental;

import coursework.vehicalrental.Schedule.Schedule;
import coursework.vehicalrental.Schedule.ScheduleRepo;
import coursework.vehicalrental.Vehicle.Vehicle;
import coursework.vehicalrental.Vehicle.VehicleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WestminsterRentalVehicleManager implements RentalVehicleManager{

    //connecting with the database using the repository
    private VehicleRepo vehicleRepo;
    private ScheduleRepo scheduleRepo;

    public WestminsterRentalVehicleManager(VehicleRepo vehicleRepo){
        this.vehicleRepo=vehicleRepo;
    }

    //Inserting vehicles to the database
    public void addVehicle(Vehicle vehicle){
        vehicleRepo.insert(vehicle);
    }
    public void addSchedule(Schedule schedule){
        scheduleRepo.insert(schedule);
    }

    //getting the vehicles from the database
    public List<Vehicle> viewVehicles(){
        return vehicleRepo.findAll();
    }
    public List<Schedule> viewSchedule(){
        return scheduleRepo.findAll();
    }

    //delete the vehicles from the database
    @Override
    public void deleteVehicle(String id) {
        this.vehicleRepo.deleteById(id);
    }

    public Optional<Vehicle> getVehicleById(String id){
        return vehicleRepo.findById(id);
    }

    /*

    public void searchVehicle(Vehicle vehicle) {

    }
*/

}
