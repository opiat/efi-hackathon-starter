package sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.domain.Event;
import sample.repository.EventRepository;

import java.util.List;

@RestController
public class EventRestController {

    private final EventRepository eventRepository;

    @Autowired
    public EventRestController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    public List<Event> events(){
        return eventRepository.findAll();
    }
}
