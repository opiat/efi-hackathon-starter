package sample.domain.builder;

import org.joda.time.DateTime;
import sample.domain.Event;
import sample.domain.Place;
import sample.domain.User;

public final class EventBuilder {

    private String name;
    private String description;
    private DateTime meetUpDate;
    private PlaceBuilder place;
    private UserBuilder owner;

    private EventBuilder(){
        //noop
    }

    public static EventBuilder event(){
        return new EventBuilder();
    }

    public EventBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public EventBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBuilder withMeetUpDate(DateTime meetUpDate) {
        this.meetUpDate = meetUpDate;
        return this;
    }

    public PlaceBuilder withPlace(){
        place = new PlaceBuilder(this);
        return place;
    }

    public UserBuilder withUser(){
        owner = new UserBuilder(this);
        return owner;
    }

    public Event build(){
        return new Event(name, description, meetUpDate, place.build(), owner.build());
    }

    public final static class PlaceBuilder {

        private String name;
        private EventBuilder parent;

        private PlaceBuilder(EventBuilder parent) {
            this.parent = parent;
        }

        public PlaceBuilder withPlace(String name) {
            this.name = name;
            return this;
        }

       public EventBuilder endPlace(){
           return parent;
       }

       public Place build(){
           return new Place(name);
       }
    }


    public final static class UserBuilder {
        private String name;
        private String email;
        private EventBuilder parent;

        private UserBuilder(EventBuilder parent) {
            this.parent = parent;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public EventBuilder endUser(){
            return parent;
        }

        public User build(){
            return new User(name, email);
        }
    }


}
