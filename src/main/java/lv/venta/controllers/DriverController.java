package lv.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.venta.models.Driver;
import lv.venta.service.IDriverCRUDService;
import lv.venta.services.impl.DriverServiceImpl;

@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverServiceImpl driverService;
	
	@GetMapping("/showAll")
	public String showAllDrivers (Model model) {
		model.addAttribute("myAllDrivers", driverService.selectAllDrivers());
		return "all-drivers-page";
	}
	
	@GetMapping("/showAll/{id}")
	public String showDriversById (@PathVariable long id, Model model) {
		try {
			Driver driver = driverService.selectDriverById(id);
			model.addAttribute("myAllDrivers", driver);
			return "one-driver-page";
		}
		catch (Exception e) {
			return "error-page";
		}
	}

	@GetMapping("/remove/{id}")
	public String removeDriverById (@PathVariable long id, Model model) {
		try {
			driverService.deleteDriverById(id);
			model.addAttribute("myAllDrivers", driverService.selectAllDrivers());
			return "all-drivers-page";
		}
		catch (Exception e) {
			return "error-page";
		}
	}
	
	@GetMapping("/insert")
	public String insertNewDriver (Driver driver) {
		return "insert-page";
	}
	
	@PostMapping("/insert")
	public String insertNewDriverPostFunction(@Valid Driver driver, BindingResult result) {
		if (!result.hasErrors()) {
			driverService.insertNewDriver(driver.getName(), driver.getSurname(), driver.getCategorie());
			return "redirect:/showAll";
		}
		else {
			return "insert-page";
		}
	}
	
	@GetMapping("/update/{id}")
	public String updateDriverById (@PathVariable("id") long id, Model model) {
		try {
			model.addAttribute("driver", driverService.selectDriverById(id));
			return "update-page";
		}
		catch (Exception e) {
			return "error-page";
		}
	}
	
	@PostMapping("/update/{id}")
	public String updateDriverByIdPostFunction (@PathVariable("id") long id, @Valid Driver driver, BindingResult result) {
		if (!result.hasErrors()) {
			try {
				Driver temp = driverService.updateDriverById(id, driver.getName(), driver.getSurname(), driver.getCategorie());
				return "redirect:/driver/showAll";
			}
			catch (Exception e) {
				return "error-page";
			}
		}
		else {
			return "update-page";
		}
	}
	
	
	
	
	
	
	
	
	
}
