package lv.venta.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lv.venta.models.Trip;

public interface ITripCRUDService {

	ArrayList<Trip> selectAllTripsByCityTitle(String title) throws Exception;

	ArrayList<Trip> selectAllTripsByDriverId(long iddriver) throws Exception;

	ArrayList<Trip> selectAllTripsToday(LocalDateTime startDateTime);

	void changeTripDriverByDriverId(List<Trip> trips, long iddriver, String newDriverName) throws Exception;

}
