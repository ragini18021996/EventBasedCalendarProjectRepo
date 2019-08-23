package com.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table
public class Client {

	@Id
	@GeneratedValue
	private int clientId;
	
	@NotEmpty(message="Cannot be empty")
	@Pattern(regexp="[a-zA-Z\\s]+$", message="Enter only Letters")
	private String clientName;
	
	@NotEmpty(message="Cannot be empty")
	private String projectName;
	
	@NotEmpty(message="Cannot be empty")
	private String arrivalDate;
	
	@NotEmpty(message="Cannot be empty")
	private String deptDate;
	
	@NotEmpty(message="Cannot be empty")
	@Pattern(regexp="[a-zA-Z\\s]+$", message="Enter only Letters")
	private String agenda;
	
	@Transient
	private String eventData;
	
	/*@OneToMany(cascade=CascadeType.PERSIST,mappedBy="cli",fetch=FetchType.EAGER)
	private Set<Events> eve=new HashSet<Events>();*/
	
	
	/*public Set<Events> getEve() {
		return eve;
	}
	public void setEve(Set<Events> eve) {
		this.eve = eve;
	}*/
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getDeptDate() {
		return deptDate;
	}
	public void setDeptDate(String deptDate) {
		this.deptDate = deptDate;
	}
	public String getAgenda() {
		return agenda;
	}
	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}
	public String getEventData() {
		return eventData;
	}
	public void setEventData(String eventData) {
		this.eventData = eventData;
	}
	
	
}
