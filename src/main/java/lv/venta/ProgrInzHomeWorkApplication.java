package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Buscategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Trip;
import lv.venta.repos.ICashierRepo;
import lv.venta.repos.ICityRepo;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.IPersonRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;

@SpringBootApplication
public class ProgrInzHomeWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrInzHomeWorkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner testModel (ICashierRepo cashierRepo, ICityRepo cityRepo, IDriverRepo driverRepo, IPersonRepo personRepo, ITicketRepo ticketRepo, ITripRepo tripRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Driver driver1 = new Driver("Paula", "Cielava", Buscategory.minibus);
				Driver driver2 = new Driver("Pēteris", "Lielais", Buscategory.schoolbus);
				Driver driver3 = new Driver("Guntis", "Eglītis", Buscategory.largebus);
				driverRepo.save(driver1);
				driverRepo.save(driver2);
				driverRepo.save(driver3);
				

				cashierRepo.save(new Cashier("Loreta", "Bērziņa"));
				cashierRepo.save(new Cashier("Liene", "Egle"));
				cashierRepo.save(new Cashier("Arturs", "Kalniņš"));
				
				City city1 = new City("Ventspils Autoosta", "Kuldīgas iela");
				City city2 = new City("Kuldīgas Autoosta", "Adatu iela");
				City city3 = new City("Skrundas Autoosta", "Liepājas iela");
				cityRepo.save(city1);
				cityRepo.save(city1);
				cityRepo.save(city1);
				
				
				
				
				
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
}
