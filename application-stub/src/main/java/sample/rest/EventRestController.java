package sample.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.domain.Event;
import sample.repository.EventRepository;

import java.util.List;

import static sample.domain.builder.EventBuilder.event;

@RestController
public class EventRestController {

    private static final Log LOGGER = LogFactory.getLog(EventRestController.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventRestController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/events")
    public List<Event> events() {
        return eventRepository.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/init/{eventNumber}")
    public String init(@PathVariable Long eventNumber) {
        eventRepository.deleteAll();
        for (int i = 0; i < eventNumber; i++) {

            Event event = event()
                    .withDescription("This is meeting in Bar number " + i)
                    .withName("Let's meet again (nr ( " + i + ")")
                    .withMeetUpDate(DateTime.now().plusDays(i).plusHours(i).plusMinutes(i))
                    .withUser()
                    .withName("Bożydar " + i)
                    .withEmail("dar.boży." + i + "@rodzice.przegrali.zaklad.pl")
                    .endUser()
                    .withPlace()
                    .withPlace("Super miejscowa " + i)
                    .endPlace()
                    .build();

            eventRepository.save(event);

        }

        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            LOGGER.info(event);
        }

        return "OK";
    }
}