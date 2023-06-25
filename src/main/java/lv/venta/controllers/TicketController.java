package lv.venta.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.models.Ticket;
import lv.venta.models.Trip;
import lv.venta.services.impl.DriverServiceImpl;
import lv.venta.services.impl.TicketService;
import lv.venta.services.impl.TripService;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private DriverServiceImpl DriverService;
	
	@GetMapping("/showAll")
	public String showAllTickets (Model model) {
		model.addAttribute("myAllTickets", ticketService.findAll());
		return "all-tickets-page";
	}
	
	@GetMapping("showAll/onlyChild")
	public String getAllChildTickets (Model model) {
		try {
			Collection<Ticket> allCildTickets = ticketService.selectAllChildTickets(false);
			model.addAttribute("myAllChildTickets", allCildTickets);
			
		}
		catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "all-tickets-page";
	}
	
	@GetMapping("/showAll/less/{threshold}")
	public String getAllTicketsWhitchPriceIsLowerThan (@PathVariable float threshold, Model model) {
		try {
			Collection<Ticket> lowPriceTickets = ticketService.selectAllTicketsWherePriceIsLow(null, threshold);
			model.addAttribute("myLowPriceTicket", lowPriceTickets);
			return "low-price-page";
		}
		catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error-page";
		}
	
	}
	
	@GetMapping("/showAll/trip/{idtrip}")
	public String getAllTicketsByTripId (@PathVariable long idtrip, Model model) throws Exception {
		Collection<Trip> allTicketsByTripId = ticketService.selectAllTicketsByTripId(idtrip);
		model.addAttribute("myAllTicketsByTripId", allTicketsByTripId);
		return "all-tickets-page";
	}
	
	@GetMapping("calculate/trip/{tripid}")
	public String calculateTripIncome (@PathVariable long idtrip, Model model) {
		try {
			float tripIncome = ticketService.calculateIncomeOfTripByTripId(idtrip);
			model.addAttribute("myTripIncome", tripIncome);
			return "ticket-income-page";
		}
		catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/calculate/cashier/{cashierid}")
	public String calculateCashierIncome (@PathVariable long idcashier, Model model) {
		try {
			float cashierIncome = ticketService.calculateIncomeOfCashierByCahierId(idcashier);
			model.addAttribute("myCashierIncome", cashierIncome);
			return "ticket-income-page";
		}
		catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error-page";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
