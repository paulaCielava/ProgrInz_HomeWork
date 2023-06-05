package lv.venta.services.impl;

import java.util.ArrayList;

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
