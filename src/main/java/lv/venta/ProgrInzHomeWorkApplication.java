package lv.venta;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Buscategory;
import lv.venta.models.Cashier;
import lv.venta.models.City;
import lv.venta.models.Driver;
import lv.venta.models.Ticket;
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
				
				
				
				Cashier cashier1 = new Cashier("Loreta", "Berzina");
				Cashier cashier2 = new Cashier("Liene", "Egle");
				Cashier cashier3 = new Cashier("Arturs", "Kalniņš");
				cashierRepo.save(cashier1);
				cashierRepo.save(cashier2);
				cashierRepo.save(cashier3);
				
				
				City city1 = new City("Ventspils Autoosta", "Kuldīgas iela");
				City city2 = new City("Kuldīgas Autoosta", "Adatu iela");
				City city3 = new City("Skrundas Autoosta", "Liepājas iela");
				cityRepo.save(city1);
				cityRepo.save(city1);
				cityRepo.save(city1);
				
				
				Trip trip1 = new Trip(driver3, LocalDateTime.now(), 1.20f);
				Trip trip2 = new Trip(driver2, LocalDateTime.now(), 3.10f);
				Trip trip3 = new Trip(driver1, LocalDateTime.now(), 2.00f);
				trip1.getCityTrips().add(city1);
				trip2.getCityTrips().add(city2);
				trip3.getCityTrips().add(city3);
				
				
				
				Ticket ticket1 = new Ticket(LocalDateTime.now(), 5.00f, trip3, false, cashier3);
				Ticket ticket2 = new Ticket(LocalDateTime.now(), 4.00f, trip2, true, cashier1);
				Ticket ticket3 = new Ticket(LocalDateTime.now(), 3.00f, trip1, false, cashier2);
				ticketRepo.save(ticket1);
				ticketRepo.save(ticket2);
				ticketRepo.save(ticket3);
				
				
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
}
