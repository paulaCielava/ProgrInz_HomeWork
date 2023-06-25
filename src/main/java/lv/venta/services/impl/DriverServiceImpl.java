package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Buscategory;
import lv.venta.models.Driver;
import lv.venta.repos.IDriverRepo;
import lv.venta.service.IDriverCRUDService;

@Service
public class DriverServiceImpl implements IDriverCRUDService{
	
	private ArrayList<Driver> allDrivers = new ArrayList<>();
	
	@Autowired
	private IDriverRepo driverRepo;
	
	@Override
	public ArrayList<Driver> selectAllDrivers(){
		return (ArrayList<Driver>) driverRepo.findAll();
	}
	
	@Override
	public Driver selectDriverById (long iddriver) throws Exception {
		if (driverRepo.existsById(iddriver)) {
			return driverRepo.findById(iddriver).get();
		}
		else {
			throw new Exception("Wrong ID");
		}
	}
	
	@Override
	public void deleteDriverById (long iddriver) throws Exception {
		if (driverRepo.existsById(iddriver)) {
			driverRepo.deleteById(iddriver);
		}
		else {
			throw new Exception("Wrong ID");
		}
	}
	
	@Override
	public Driver insertNewDriver (String name, String surname, Buscategory categorie) {
		Driver temp = driverRepo.save(new Driver(name, surname, categorie));
		return temp;
	}
	
	@Override
	public Driver updateDriverById (long iddriver, String name, String surname, Buscategory categorie) throws Exception {
		for (Driver temp : allDrivers) {
			if (temp.getIddriver() == iddriver) {
				temp.setName(name);
				temp.setSurname(surname);
				temp.setCategorie(categorie);
				return temp;
			}
		}
		throw new Exception("Wrong ID");
	}
	
	
}
