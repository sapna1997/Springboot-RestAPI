package com.mySqlConnection.example.response;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.mySqlConnection.example.entity.Contacts;
import com.mySqlConnection.example.entity.Views;
@Component
public class ResponseClass {
	
	@JsonView(Views.Public.class)
	private String msg;
	
	private List<Contacts> contactList;
	private Optional<Contacts> contact;
	private int rowsAffected;
	
	

	public int getRowsAffected() {
		return rowsAffected;
	}

	public void setRowsAffected(int rowsAffected) {
		this.rowsAffected = rowsAffected;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Contacts> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contacts> contactList) {
		this.contactList = contactList;
	}

	public Optional<Contacts> getContact() {
		return contact;
	}

	public void setContact(Optional<Contacts> contact2) {
		this.contact = contact2;
	}

	
	}
	
	


