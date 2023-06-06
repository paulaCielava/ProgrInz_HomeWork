package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.ITicketRepo;
import lv.venta.service.ITicketCRUDService;

public class TicketServiceImpl implements ITicketCRUDService{

	@Autowired
	private ITicketRepo ticketRepo;
	
	
	private ArrayList<Ticket> getAllTickets() {
        ArrayList<Ticket> allTickets = new ArrayList<>();
        return allTickets;
    }
	
	@Override
	public ArrayList<Ticket> selectAllChildTickets (boolean isChild){
		ArrayList<Ticket> childTickets = new ArrayList<>();
		ArrayList<Ticket> allTickets = getAllTickets();
        for (Ticket temp : allTickets) {
            if (temp.isChild() == isChild) {
                childTickets.add(temp);
            }
        }
        return childTickets;
	}
	
	public ArrayList<Ticket> selectAllTicketsWherePriceIsLow(ArrayList<Ticket> tickets, float price) {
        ArrayList<Ticket> lowPriceTickets = new ArrayList<>();
        for (Ticket temp : tickets) {
            if (temp.getPrice() < price) {
                lowPriceTickets.add(temp);
            }
        }
        return lowPriceTickets;
    }
	

	@Override
	public ArrayList<Trip> selectAllTicketsByTripId (long idtrip) throws Exception{
		if (ticketRepo.existsById(idtrip)) {
			return ticketRepo.selectAllTripsByDriverId(idtrip);
		}
		else {
			throw new Exception("Wrong id");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
