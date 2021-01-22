package com.h2restapi.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.h2restapi.api.dao.CustomerRepo;
import com.h2restapi.api.entity.Customer;

@RestController
@RequestMapping("/api")
public class Home {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@GetMapping("/all")
	public ResponseEntity<?> getall()
	{
		try {
			List<Customer> l=this.customerRepo.findAll();
			return ResponseEntity.ok(l);
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured"+e.getMessage(), 
      HttpStatus.OK);
		}
	}
	
	@GetMapping("/getspecificbyid/{id}")
	public ResponseEntity<?> getspecificbyid(@PathVariable("id") int id)
	{
		try {
			Customer l=this.customerRepo.findById(id);
			return ResponseEntity.ok(l);
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured"+e.getMessage(), 
      HttpStatus.OK);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> savecustomer(@RequestBody Customer c)
	{
		try {
			this.customerRepo.save(c);
			System.out.println(c);
			return ResponseEntity.ok("saved customer");
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured"+e.getMessage(), 
      HttpStatus.OK);
		}
	}
	
	@PatchMapping("/editbyid")
	public ResponseEntity<?> editbyid(@RequestBody Customer c)
	{
		try {
			int id=c.getId();
			Customer l=this.customerRepo.findById(id);
			System.out.println(l);
			if(l==null)
			{
				return ResponseEntity.ok("Customer not found");
			}
			else
			{
				l.setEmail(c.getEmail());
				l.setAddress(c.getAddress());
				l.setName(c.getName());
				l.setPhoneno(c.getPhoneno());
				this.customerRepo.save(l);
				return ResponseEntity.ok(l); 
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured"+e.getMessage(), 
				      HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/deleteall")
	public ResponseEntity<?> deleteall()
	{
		try {
			this.customerRepo.deleteAll();
			return ResponseEntity.ok("deleted all");
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured"+e.getMessage(), 
				      HttpStatus.OK);
		}
	}
	

}
