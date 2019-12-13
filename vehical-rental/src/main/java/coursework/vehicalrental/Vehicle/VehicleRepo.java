package coursework.vehicalrental.Vehicle;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//connecting with the database
@Repository
public interface VehicleRepo extends MongoRepository<Vehicle,String> {
}
