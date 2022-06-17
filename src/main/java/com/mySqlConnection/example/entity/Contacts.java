package com.mySqlConnection.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "cell_no")
	private String cellNo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	
	
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", cellNo=" + cellNo
				+ ", getId()=" + getId() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getCellNo()=" + getCellNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	

}
