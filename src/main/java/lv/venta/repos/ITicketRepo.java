package lv.venta.repos;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;

public interface ITicketRepo extends CrudRepository<Ticket, Long>{

	ArrayList<Ticket> selectAllTicketsByTripId(long idticket);

	ArrayList<Trip> selectAllTripsByDriverId (long iddriver);

	
	
	
	
	
	
}
