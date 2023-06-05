package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
				
				
				
				
				
				
				
				
				
			}
		};
	}
	
	
	
	
	
	
	
	
	
	
	
}
