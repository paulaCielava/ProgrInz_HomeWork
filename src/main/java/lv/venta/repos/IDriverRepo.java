package lv.venta.repos;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Driver;

public interface IDriverRepo extends CrudRepository<Driver, Long>{
	
	boolean existsByNameAndSurname (String name, String surname);
	
	Driver findByIddriver(long iddriver);
}
