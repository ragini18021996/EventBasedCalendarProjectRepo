package com.entities;

import javax.persistence.*;



@Entity
@Table
public class Events {
	
	@Override
	public String toString() {
		return "Events [eventId=" + eventId + ", eventType=" + eventType
				+ ", startTimeDate=" + startTimeDate + ", endTimeDate="
				+ endTimeDate + ", place=" + place + ", cli=" + cli + "]";
	}
	@Id
	@GeneratedValue

	private int eventId;

	private String eventType;
	
	private String startTimeDate;
	
	private String endTimeDate;
	
	private String place;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private Client cli;
	

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
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
	public String getStartTimeDate() {
		return startTimeDate;
	}
	public void setStartTimeDate(String startTimeDate) {
		this.startTimeDate = startTimeDate;
	}
	public String getEndTimeDate() {
		return endTimeDate;
	}
	public void setEndTimeDate(String endTimeDate) {
		this.endTimeDate = endTimeDate;
	}
	public Client getCli() {
		return cli;
	}
	public void setCli(Client cli) {
		this.cli = cli;
	}
	
	
	
	
}
