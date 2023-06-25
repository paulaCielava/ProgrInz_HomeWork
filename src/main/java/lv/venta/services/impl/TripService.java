package lv.venta.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITripRepo;
import java.util.List;
import java.util.Optional;


@Service
public abstract class TripService implements ITripRepo{
	
	@Autowired
	private ITripRepo tripRepo;
	
	@Autowired
	private IDriverRepo driverRepo;
	
	public TripService(ITripRepo tripRepo, IDriverRepo driverRepo) {
		this.tripRepo = tripRepo;
		this.driverRepo = driverRepo;
	}
	
	private ArrayList<Trip> getAllTrips (){
		return (ArrayList<Trip>) tripRepo.findAll();
	}
	
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
	
	@Override
	public ArrayList<Trip> selectAllTripsToday (LocalDateTime startDateTime){
		ArrayList<Trip> tripsToday = new ArrayList<>();
        ArrayList<Trip> allTrips = getAllTrips();

        for (Trip trip : allTrips) {
            if (trip.getStartDateTime().toLocalDate().equals(startDateTime.toLocalDate())) {
                tripsToday.add(trip);
            }
        }

        return tripsToday;
	}
	
	@Override
	public void changeTripDriverByDriverId(long idtrip, long iddriver) throws Exception {
		Trip trip = tripRepo.findById(idtrip);
		if (trip != null) {
			Driver driver = driverRepo.findById(iddriver);
			if (driver != null) {
				trip.setTripDriver(driver);
				tripRepo.save(trip);
			}
			else {
				throw new RuntimeException("Not found with this id " + iddriver);
			}
		}
		else {
			throw new RuntimeException("Not found with this id " + idtrip);
		}
		
		/*
		boolean driverExists = false;

	    for (Trip temp : trips) {
	        if (tripRepo.existsById(iddriver)) {
	            temp.setTripDriver(newDriverName);
	            driverExists = true;
	        }
	    }

	    if (!driverExists) {
	        throw new Exception("Driver don`t exists");
	    }
	    */
	}
	
	
	
	
}
