package coursework.vehicalrental.Vehicle;

import coursework.vehicalrental.RentalVehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Request+Controller
@RestController
@RequestMapping("/wesRental")
@CrossOrigin("http://localhost:3000")
public class VehicleController {
    //creating an instance variable from the vehicle repository
    private VehicleRepo vehicleRepo;

    @Autowired
    private RentalVehicleManager rentalVehicleManager;

    public VehicleController(VehicleRepo vehicleRepo){
        this.vehicleRepo=vehicleRepo;
    }
//requesting the vehicles with GET
    @GetMapping("/vehicles")
    public List<Vehicle> getVehicles(){
        //getting the vehicle list from the repository
        List<Vehicle> vehicles=rentalVehicleManager.viewVehicles();
        return vehicles;
    }

//getting vehicle details by the ID
    @GetMapping("/vehicles/{id}")
    public Optional<Vehicle> getVehicleById(@PathVariable("id")String id){
        Optional<Vehicle> vehicles=rentalVehicleManager.getVehicleById(id);
        return vehicles;
    }

// using POST send list of vehicles
    @PostMapping
    public void insertVehicle(@RequestBody Vehicle vehicle){
        rentalVehicleManager.addVehicle(vehicle);
    }

//Using delete to delete a record by the ID
    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") String id){
        rentalVehicleManager.deleteVehicle(id);
    }




}
