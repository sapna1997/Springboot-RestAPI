package com.mySqlConnection.example.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.mySqlConnection.example.RestApiAllMethodsApplication;
import com.mySqlConnection.example.entity.Contacts;
import com.mySqlConnection.example.entity.Views;
import com.mySqlConnection.example.repository.mySqlRepository;
import com.mySqlConnection.example.response.ResponseClass;
import com.mySqlConnection.example.service.ServiceClass;

@RestController
public class Controller {
	
	@Autowired
	private ServiceClass service;
	
	@Autowired
	private mySqlRepository repo;
	
	@Autowired
	private ResponseClass response;
	
    Logger log=LoggerFactory.getLogger(Controller.class);

	
	@GetMapping("/allContacts")
	public ResponseEntity<ResponseClass> getContactList(){
		
		ResponseClass response = new ResponseClass();
		
		response = service.getAllContacts();
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/Contact/ByID")
	public ResponseEntity<ResponseClass> getContactById(@RequestParam(value="id", required=true) int id){
		
	      System.out.println("In Controller");

		//return this.repo.findById(id).orElseThrow(()->new NoSuchElementException("ID not found"));
		response=service.getContactById(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/contact")
	public ResponseEntity<ResponseClass> createContact(@RequestBody Contacts contact){
		
		log.debug("Contacts: "+ contact.getFirstName());

		response=service.createContact(contact);
		
		log.info("created:" + response.getMsg());
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	@JsonView(Views.Public.class)
	@PutMapping("/update/contact")
	public ResponseEntity<ResponseClass> updateContact(@RequestParam(value="id",required=true) int id, @RequestBody Contacts cont){
		
		response=service.updateContact(id, cont);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@JsonView(Views.Public.class)	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseClass> deleteById(@PathVariable("id") int id)
	{
		response=service.deleteByID(id);
		HttpStatus httpStatus;
		if(response.getRowsAffected() == 0) {
			response.setMsg("id is not found for deleting record");
			httpStatus = HttpStatus.NOT_FOUND;
		}
		else
		{
			response.setMsg("Record deleted successfully");
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<>(response, httpStatus);
	}
	
	
}