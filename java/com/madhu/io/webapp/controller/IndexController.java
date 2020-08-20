package com.madhu.io.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.madhu.io.webapp.model.Customer;
import com.madhu.io.webapp.repository.WebAppRepository;
import com.madhu.io.webapp.service.CustomerService;

@Controller
public class IndexController {

	@Autowired
	WebAppRepository repo;

	@Autowired
	CustomerService service;

	@GetMapping("/")
	public String index(Model model) {
		List<Customer> customers = repo.findAll();
		model.addAttribute("customers", customers);
		return "index";
	}

	@GetMapping("/find")
	public String viewHomePage(Model model, @Param("name") String name) {
		List<Customer> listCustomers = service.listAll(name);
		model.addAttribute("listCustomers", listCustomers);
		model.addAttribute("name", name);

		return "view";
	}

	@RequestMapping(value = "add")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addCustomer";
	}

	@RequestMapping(value = "customers")
	public String search(Model model) {
		List<Customer> customer = repo.findAll();
		model.addAttribute("customer", new Customer());
		model.addAttribute("customers", customer);
		return "customerListPage";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Customer customer) {
		repo.save(customer);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable("id") Long id, Model model) {
		repo.deleteById(id);
		return "redirect:/";
	}

}
