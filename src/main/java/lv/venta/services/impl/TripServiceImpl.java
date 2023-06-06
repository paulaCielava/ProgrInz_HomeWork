package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.ITripRepo;
import lv.venta.service.ITripCRUDService;

public class TripServiceImpl implements ITripCRUDService{

	@Autowired
	private ITripRepo tripRepo;
	
	@Override
	public ArrayList<Trip> selectAllTripsByCityTitle(String title) throws Exception{
		if (title != null) {
			ArrayList<Trip> allCitiesWithTitle = tripRepo.findByTitleIgnoreCase(title);
			return allCitiesWithTitle;
		}
		else {
			throw new Exception("Wrong title");
		}
	}
	
	@Override
	public ArrayList<Trip> selectAllTripsByDriverId (long iddriver) throws Exception{
		if (tripRepo.existsById(iddriver)) {
			return tripRepo.selectAllTripsByDriverId(iddriver);
		}
		else {
			throw new Exception("Wrong id");
		}
	}
	
	private ArrayList<Trip> getAllTrips (){
		return (ArrayList<Trip>) tripRepo.findAll();
	}
	
	@Override
	public ArrayList<Trip> selectAllTripsToday (LocalDateTime startDateTime){
		ArrayList<Trip> tripsToday = new ArrayList<>();
        List<Trip> allTrips = getAllTrips();

        for (Trip trip : allTrips) {
            if (trip.getStartDateTime().toLocalDate().equals(startDateTime.toLocalDate())) {
                tripsToday.add(trip);
            }
        }

        return tripsToday;
	}
	
	@Override
	public void changeTripDriverByDriverId(List<Trip> trips, long iddriver, String newDriverName) throws Exception {
	    boolean driverExists = false;

	    for (Trip temp : trips) {
	        if (tripRepo.existsById(iddriver)) {
	            temp.setDriver(newDriverName);
	            driverExists = true;
	        }
	    }

	    if (!driverExists) {
	        throw new Exception("Driver don`t exists");
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
