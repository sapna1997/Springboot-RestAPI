package com.mySqlConnection.example.service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mySqlConnection.example.Exception.ContactExceptionHandler;
import com.mySqlConnection.example.entity.Contacts;
import com.mySqlConnection.example.repository.mySqlRepository;
import com.mySqlConnection.example.response.ResponseClass;

@Service
public class ServiceClass {
	
	@Autowired
	private mySqlRepository repo;
	
	@Autowired
	private ResponseClass response;
	
	public ResponseClass getAllContacts() {
		
		
		List<Contacts> contactList = repo.findAll();
		
		response.setContactList(contactList);
		
		response.setMsg("length of contact list: "+contactList.size());
		return response;
	}
	
	public ResponseClass getContactById(int id)
	{
		Optional<Contacts> contact=Optional.of(new Contacts());
		
		contact=repo.findById(id);
		if(contact==null)
			throw new NoSuchElementException("Record not available");
	
		
		response.setContact(contact);
		response.setMsg("Geeting Record for ID: "+ id);
		return response;
	}
	
	public ResponseClass createContact(Contacts contact)
	{
		Optional<Contacts> cont = Optional.of(repo.save(contact));
		response.setMsg("Below record has been Created");
		response.setContact(cont);
		return response;
	}

	public ResponseClass updateContact(int id, Contacts cont ) {
		String firstName = cont.getFirstName();
		int affectedRows = repo.updateContactName(id, firstName);
		response.setMsg("following record is updated with id: "+id);
		
		return response;
	}

	public ResponseClass deleteByID(int id) {
		int rowsAffected=repo.deleteRecordById(id);
		response.setRowsAffected(rowsAffected);
		return response;
	}

}
