/**
 * 
 */
package com.assaassociates.syraway.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author waheb
 *
 */
@Entity
@Table(name = "COLLABORATOR")
public class Collaborator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6518103669032643479L;
	@Id
	@Column(name="COLLABORATOR_ID")
	private String id;
	@Column(name="FIRST_NAME")
	private String firstName; 
	@Column(name="LAST_NAME")
	private String lastName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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

}
