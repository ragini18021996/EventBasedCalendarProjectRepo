package com.entities;



import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table
public class Events {
	
	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventType=" + eventType
				+ ", startTimeDate=" + startTimeDate + ", endTimeDate="
				+ endTimeDate + ", cli=" + cli + "]";
	}
	@Id
	@GeneratedValue

	private int eventId;
	@NotEmpty(message="Cannot be empty")
	private String eventType;
	
	
	private Date startTimeDate;
	
	private Date endTimeDate;
	

	
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Client cli;
	

	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Date getStartTimeDate() {
		return startTimeDate;
	}
	public void setStartTimeDate(Date startDateTime) {
		this.startTimeDate = startDateTime;
	}
	public Date getEndTimeDate() {
		return endTimeDate;
	}
	public void setEndTimeDate(Date endTimeDate) {
		this.endTimeDate = endTimeDate;
	}
	public Client getCli() {
		return cli;
	}
	public void setCli(Client cli) {
		this.cli = cli;
	}
	
	
	
	
}
