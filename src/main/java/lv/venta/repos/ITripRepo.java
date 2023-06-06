package lv.venta.repos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Trip;

public interface ITripRepo extends CrudRepository<Trip, Long>{

	ArrayList<Trip> findByTitleIgnoreCase(String title);

	// selectAllTripsByDriverId
	// SELECT * FROM trip_table WHERE iddriver = <iddriver>;
	ArrayList<Trip> selectAllTripsByDriverId (long iddriver);
	
	// selectAlTripsToday
	//SELECT * FROM trip_tabula WHERE startDateTime = CURRENT_DATE;
	ArrayList<Trip> selectAlTripsToday (LocalDateTime startDateTime);
	
	
	
	
	
	
	
	
	
	
	
	
}
