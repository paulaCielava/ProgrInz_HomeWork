package lv.venta.repos;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Driver;
import lv.venta.models.Trip;

public interface ITripRepo extends CrudRepository<Trip, Long>{

	ArrayList<Trip> findByTitleIgnoreCase(String title);

	// selectAllTripsByDriverId
	// SELECT * FROM trip_table WHERE iddriver = <iddriver>;
	ArrayList<Trip> selectAllTripsByDriverId (long iddriver) throws Exception;
	
	ArrayList<Trip> selectAllTripsByCityTitle(String title) throws Exception;

	ArrayList<Trip> selectAllTripsToday(LocalDateTime startDateTime);

	void changeTripDriverByDriverId(ArrayList<Trip> trips, long iddriver, Driver newDriverName) throws Exception;
	
	Trip fingByIdTrip (long idtrip);
	
	
	
	
	
	
	
	
	
	
}
