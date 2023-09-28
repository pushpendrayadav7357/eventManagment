package com.university.eventmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @NotBlank(message = "Event name is required")
    private String eventName;

    @NotBlank(message = "Location of event is required")
    private String locationOfEvent;

    @NotNull(message = "Date is required")
    private Date date;

    @NotNull(message = "Start time is required")
    private Date startTime;

    @NotNull(message = "End time is required")
    private Date endTime;
    // Getter and setter methods for locationOfEvent
    public String getLocationOfEvent() {
        return locationOfEvent;
    }

    public void setLocationOfEvent(String locationOfEvent) {
        this.locationOfEvent = locationOfEvent;
    }

    // Getter and setter methods for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and setter methods for startTime
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    // Getter and setter methods for endTime
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}

