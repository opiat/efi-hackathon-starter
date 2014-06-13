package sample;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import sample.domain.Event;
import sample.repository.EventRepository;

import java.util.List;

import static sample.domain.builder.EventBuilder.event;

@ComponentScan(basePackageClasses = Application.class)
@EnableAutoConfiguration
@EnableMongoRepositories
@Configuration
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

    private static final Log LOGGER = LogFactory.getLog(Application.class);

    @Autowired
    private EventRepository eventRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public void init()  {

        eventRepository.deleteAll();


        for(int i = 0; i < 10 ; i ++) {

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
        for(Event event : events) {
            LOGGER.info(event);
        }
    }

    @Override
    public void run(String... strings) throws Exception {
        init();
    }
}
