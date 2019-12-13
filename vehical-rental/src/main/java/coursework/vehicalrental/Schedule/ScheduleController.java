package coursework.vehicalrental.Schedule;

import coursework.vehicalrental.RentalVehicleManager;
import coursework.vehicalrental.Vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wesBooking")
@CrossOrigin("http://localhost:3000")
public class ScheduleController {
    private ScheduleRepo scheduleRepo;

    @Autowired
    private RentalVehicleManager rentalVehicleManager;

    public ScheduleController(ScheduleRepo scheduleRepo){
        this.scheduleRepo=scheduleRepo;
    }

    @GetMapping("/booking")
    public List<Schedule> getSchedules(){
        //getting the vehicle list from the repository
        List<Schedule> schedule=scheduleRepo.findAll();
        return schedule;
    }
/*
    //getting vehicle details by the ID
    @GetMapping("/booking/{id}")
    public Optional<Schedule> getVehicleById(@PathVariable("id")String id){
        Optional<Schedule> schedule=rentalVehicleManager.;
        return schedule;
    }*/

    // using POST send list of vehicles
    @PostMapping
    public void insertSchedule(@RequestBody Schedule schedule){
       // rentalVehicleManager.addSchedule(schedule);
        scheduleRepo.insert(schedule);
    }
/*
    //Using delete to delete a record by the ID
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") String id){
        rentalVehicleManager.deleteVehicle(id);
    }
*/

}
