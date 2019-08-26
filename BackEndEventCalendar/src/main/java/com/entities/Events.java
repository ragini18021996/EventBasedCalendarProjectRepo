package com.entities;



import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;




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
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
	private Date startTimeDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
	private Date endTimeDate;
	

	
	
	public Date getStartTimeDate() {
		return startTimeDate;
	}
	public void setStartTimeDate(Date startTimeDate) {
		this.startTimeDate = startTimeDate;
	}
	public Date getEndTimeDate() {
		return endTimeDate;
	}
	public void setEndTimeDate(Date endTimeDate) {
		this.endTimeDate = endTimeDate;
	}
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
	
	public Client getCli() {
		return cli;
	}
	public void setCli(Client cli) {
		this.cli = cli;
	}
	
	
	
	
}
