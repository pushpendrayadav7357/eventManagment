package com.university.eventmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {

        Event savedEvent = eventRepository.save(event);
        return savedEvent;
    }

    public Event updateEvent(Long eventId, Event updatedEvent) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            event.setEventName(updatedEvent.getEventName());
            event.setLocationOfEvent(updatedEvent.getLocationOfEvent());
            event.setDate(updatedEvent.getDate());
            event.setStartTime(updatedEvent.getStartTime());
            event.setEndTime(updatedEvent.getEndTime());
            return eventRepository.save(event);
        }
        return null;
    }

    public boolean deleteEvent(Long eventId) {
        if (eventRepository.existsById(eventId)) {
            eventRepository.deleteById(eventId);
            return true;
        }
        return false;
    }

    public List<Event> getAllEventsByDate(Date date) {
        return eventRepository.findByDate(date);
    }
}
