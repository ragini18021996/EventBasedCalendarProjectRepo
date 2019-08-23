package com.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table
public class Client {

	@Id
	@GeneratedValue
	private int clientId;
	private String account;
	
	@NotEmpty(message="Cannot be empty")
	@Pattern(regexp="[a-zA-Z\\s]+$", message="Enter only Letters")
	private String clientName;
	
	@NotEmpty(message="Cannot be empty")
	private String projectName;
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName
				+ ", projectName=" + projectName + ", arrivalDate="
				+ arrivalDate + ", deptDate=" + deptDate + ", agenda=" + agenda
				+ ", eventData=" + eventData + "]";
	}
	@NotNull
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date arrivalDate;
	
	@NotNull
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deptDate;
	
	@NotEmpty(message="Cannot be empty")
	@Pattern(regexp="[a-zA-Z\\s]+$", message="Enter only Letters")
	private String agenda;
	
	@Transient
	private String eventData;
	
	@Transient
	private String stringarrive;
	@Transient
	private String stringdepart;
	
	
	
	/*@OneToMany(cascade=CascadeType.PERSIST,mappedBy="cli",fetch=FetchType.EAGER)
	private Set<Events> eve=new HashSet<Events>();*/
	
	
	public String getStringarrive() {
		return stringarrive;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setStringarrive(String stringarrive) {
		this.stringarrive = stringarrive;
	}
	public String getStringdepart() {
		return stringdepart;
	}
	public void setStringdepart(String stringdepart) {
		this.stringdepart = stringdepart;
	}
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
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public Date getDeptDate() {
		return deptDate;
	}
	public void setDeptDate(Date deptDate) {
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
