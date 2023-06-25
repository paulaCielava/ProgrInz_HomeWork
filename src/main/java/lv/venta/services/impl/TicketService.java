package lv.venta.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.repos.IDriverRepo;
import lv.venta.repos.ITicketRepo;
import lv.venta.repos.ITripRepo;

@Service
public abstract class TicketService implements ITicketRepo{
	
	@Autowired
	private ITicketRepo ticketRepo;
	@Autowired
	private ITripRepo tripRepo;
	
	public TicketService(ITicketRepo ticketRepo, ITripRepo tripRepo) {
		this.ticketRepo = ticketRepo;
		this.tripRepo = tripRepo;
	}
	
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
	
	@Override
	public float calculateIncomeOfTripByTripId (long idtrip){
		float totalIncome = 0.0f;
		ArrayList<Ticket> tripTickets = ticketRepo.selectAllTicketsByTripId(idtrip);
		
		for (Ticket temp : tripTickets) {
			totalIncome += temp.getPrice(); //pievieno iegūto cenu totalIncome
			
		}
		return totalIncome;
	}
	
	@Override
	public float calculateIncomeOfCashierByCahierId (long idcashier) {
		float totalCashierIncome = 0.0f;
		ArrayList<Ticket> allTickets = getAllTickets(); // iegūst visu biļešu sarakstu
		
		for (Ticket temp : allTickets) {
			if (temp.getTicketCashier().equals(String.valueOf(idcashier))) {
				totalCashierIncome += temp.getPrice(); //pievieno biļetes cenu kopējajai ienākumu summai  
			}
		}
		return totalCashierIncome; //atgriež kopējo summu no biļetēm, ko pārdevis konkrēts kasieris
	}
	
	
	

}
