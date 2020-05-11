package com.example.helloworldspringboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController 
{
	@Autowired
	CustomerRepository repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		return repo.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id)
	{
		return repo.findById(id);
	}
	
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer)
	{
		repo.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable("id") int id)
	{
		Customer c = repo.getOne(id);
		repo.delete(c);
		return "deleted";
	}
}
