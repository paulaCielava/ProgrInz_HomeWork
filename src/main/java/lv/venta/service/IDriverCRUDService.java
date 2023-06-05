package lv.venta.service;

import java.util.ArrayList;

import lv.venta.models.Buscategory;
import lv.venta.models.Driver;

public interface IDriverCRUDService {

	ArrayList<Driver> selectAllDrivers();

	Driver selectDriverById(long iddriver) throws Exception;

	void deleteDriverById(long iddriver) throws Exception;

	Driver insertNewDriver(String name, String surname, Buscategory categorie);

	Driver updateDriverById(long iddriver, String name, String surname, Buscategory categorie) throws Exception;

}
