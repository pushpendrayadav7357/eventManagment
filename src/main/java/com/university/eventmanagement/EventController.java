package com.university.eventmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    // Add Event
    @PostMapping
    public ResponseEntity<Event> addEvent(@Validated @RequestBody Event event) {
        Event newEvent = eventService.addEvent(event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    // Update Event
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long eventId,
            @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(eventId, updatedEvent);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete Event
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        boolean deleted = eventService.deleteEvent(eventId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Events by Date
    @GetMapping
    public ResponseEntity<List<Event>> getAllEventsByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<Event> events = eventService.getAllEventsByDate(date);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
