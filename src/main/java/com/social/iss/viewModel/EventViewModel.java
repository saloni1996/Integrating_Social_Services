package com.social.iss.viewModel;

import com.social.iss.dataModel.Event;
import com.social.iss.dataModel.Event_Type;
import com.social.iss.databaseRepositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Service
public class EventViewModel {
    @Autowired
    EventRepository eventRepository;

    public List<Event_Type> getAllEventTypes() {
        return asList(Event_Type.values());
    }

    public String addEvent(String eventName
            , Event_Type eventType, String description,
                           Date startDate, Date endDate, Integer id) {
        Event event = new Event();
        event.setName(eventName);
        event.setEventType(eventType);
        event.setDescription(description);
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setNgoId(id);
        eventRepository.save(event);
        return "Success";
    }

    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    public String deleteEntity(Integer eventId) {
        eventRepository.deleteById(eventId);
        return "Success";
    }

    public List<Event> getEventByName(String eventName) {
        List<Event> eventList = new ArrayList<>();
        eventRepository.findAll().forEach((event) -> {
            if(event.getName().contains(eventName)) {
                eventList.add(event);
            }
        });
        return eventList;
    }

    public List<Event> getEventByType(Event_Type eventType) {
        List<Event> eventList = new ArrayList<>();
        eventRepository.findAll().forEach((event) -> {
            if(event.getEventType().equals(eventType)) {
                eventList.add(event);
            }
        });
        return eventList;
    }

    public List<Event> getEventsByNgoId(Integer ngoId) {
        List<Event> eventList = new ArrayList<>();
        eventRepository.findAll().forEach((event) -> {
            if(event.getNgoId().equals(ngoId)) {
                eventList.add(event);
            }
        });
        return eventList;
    }

}
