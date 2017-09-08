package com.cyberdemon.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cyberdemon.springboot.model.Car;
import com.cyberdemon.springboot.service.CarService;
import com.cyberdemon.springboot.service.CarServiceInteger;

@Controller
public class WebController {
	@Autowired
	CarService carService;
	
	@Autowired
	CarServiceInteger carServiceInteger;

	String carComp;

	@RequestMapping(value = { "/", "home" })
	public String home() {
		return "home";
	}

	@RequestMapping(value = { "/welcome" })
	public String welcome() {
		return "welcome";
	}

	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = { "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/403")
	public String Error403() {
		return "403";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void search(Map<String, Object> model){
		// ricorda che all html gli passi una lista con nome companyList
		model.put("companyList", carService.findByCompany("Porsche"));
	}
	// la lista che devo passare al template, viene filtrata con il param
		// in ingresso, ricevuto dal form dell html
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public void feedback(Map<String, Object> model,String company){
		// ricorda che all html gli passi una lista con nome companyList
		model.put("companyList", carService.findByCompany(company));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(ModelMap modelMap) {
		modelMap.put("car", new Car());
		return "insert";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("car") Car car, ModelMap modelMap) {
		carService.addCar(car);
		return "home";
	}
	
	@RequestMapping(value = "/list")
	public List<Car> list(Map<String, Object> model) {
		List<Car> myCarList = carService.getAllCars();
		model.put("carsList", myCarList);
		return myCarList;
	}
	
	@RequestMapping("car/delete/{id}")
	public String delete(@PathVariable Integer id){
	    carServiceInteger.delete(id);
	    return "redirect:/list";
	}
}
