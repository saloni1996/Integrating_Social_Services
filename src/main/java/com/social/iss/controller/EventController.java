package com.social.iss.controller;

import com.social.iss.dataModel.Event;
import com.social.iss.dataModel.Event_Type;
import com.social.iss.viewModel.EventViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event")
@Api(value="Event management")
public class EventController {

    @Autowired
    EventViewModel eventViewModel;

    @ApiOperation(value = "Returns Event types")
    @GetMapping(value = "/getEventTypes")
    public List<Event_Type> getEventTypes() {
        return eventViewModel.getAllEventTypes();
    }

    @ApiOperation(value = "Adds list of Event")
    @PostMapping(value = "/addEvent")
    public @ResponseBody
    String addEvent(@RequestParam String eventName
            , @RequestParam Event_Type eventType, @RequestParam String description,
                    @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam Integer id) {
        return eventViewModel.addEvent(eventName, eventType,description,startDate,endDate, id);
    }

    @ApiOperation(value = "list of all events")
    @GetMapping(value = "/listEvent")
    public @ResponseBody Iterable<Event> listOfEvents() {
        return eventViewModel.getAllEvents();
    }

    @ApiOperation(value = "list of all events by name")
    @GetMapping(value = "/getListOfEventsByName")
    public @ResponseBody List<Event> getListofEventsByName(@RequestParam String eventName) {
        return eventViewModel.getEventByName(eventName);
    }

    @ApiOperation(value = "list of all events by event type")
    @GetMapping(value = "/getListOfEventsByEventType")
    public @ResponseBody Iterable<Event> getListofEventsByEventType(@RequestParam Event_Type eventType) {
        return eventViewModel.getEventByType(eventType);
    }

    @ApiOperation(value = "list of all events by NGO id")
    @GetMapping(value = "/getListOfEventsByNGOId")
    public @ResponseBody Iterable<Event> getListofEventsByNGOId(@RequestParam Integer ngoID) {
        return eventViewModel.getEventsByNgoId(ngoID);
    }

    @ApiOperation(value = "details of an event by event id")
    @GetMapping(value = "/getDetailsOfEventsByEventId")
    public @ResponseBody
    Optional<Event> getEventDetailsById(@RequestParam Integer eventId) {
        return eventViewModel.getEventById(eventId);
    }

    @ApiOperation(value = "delete an event whose id is given")
    @GetMapping(value = "/deleteEvent")
    public @ResponseBody String deleteEvent(@RequestParam Integer eventId) {
        return eventViewModel.deleteEntity(eventId);
    }
}
