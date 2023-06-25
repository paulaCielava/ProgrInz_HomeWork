package lv.venta.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lv.venta.models.Trip;
import lv.venta.services.impl.TripService;

@Controller
@RequestMapping("/trip")
public class TripController {

	@Autowired
	private TripService tripService;
	
	@GetMapping("/showAll")
	public String showAllTrips (Model model) {
		model.addAttribute("myAllTrips", tripService.findAll());
		return "all-trips-page";
	}
	
	@GetMapping("/showAll/city/{cityTitle}")
	public String getAllTripsByCityTitle (@PathVariable("cityTitle") String title, Model model) {
		if (title != null) {
			try {
				ArrayList<Trip> allTripsByCityTitle = tripService.selectAllTripsByCityTitle(title);
				model.addAttribute("myAllTrips", allTripsByCityTitle);
				return "all-trips-page";
			}
			catch (Exception e) {
				return "error-page";
			}
		}
		return "error-page";
	}
	
	@GetMapping("/showAll/driver/{driverid}")
	public String getAllTripsByDriverId (@PathVariable("driverid") long iddriver, Model model) throws Exception {
		ArrayList<Trip> allTripsByDriverId = tripService.selectAllTripsByDriverId(iddriver);
		model.addAttribute("myAllTrips", allTripsByDriverId);
		return "all-trips-page";
 	}
	
	@GetMapping("/showAll/today")
	public String getAllTripcToday (Model model){
		ArrayList<Trip> allTripsToday = tripService.selectAllTripsToday(null);
		model.addAttribute("myAllTrips", allTripsToday);
		return "all-trips-page";
	}
	
	@GetMapping("/changeDriver/{tripid}/{driverid}")
	public String changeTripDriver (@PathVariable("tripid") long idtrip, @PathVariable("driverid") long iddriver) throws Exception {
		tripService.changeTripDriverByDriverId(idtrip, iddriver);
		return "redirect:/trip/showAll";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
