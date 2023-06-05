package lv.venta.service;

import java.util.ArrayList;

import lv.venta.models.Trip;

public interface ITripCRUDService {

	ArrayList<Trip> selectAllTripsByCityTitle(String title) throws Exception;

}
