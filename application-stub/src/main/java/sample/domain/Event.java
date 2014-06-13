package sample.domain;

import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Event implements Serializable{

    @Id
    private ObjectId id;
    private String name;
    private String description;
    @CreatedDate
    private DateTime meetUpDate;
    private Place place;
    private User owner;

    protected Event() {
        //spring data
    }

    public Event(String name, String description, DateTime meetUpDate, Place place, User owner) {
        this.name = name;
        this.description = description;
        this.meetUpDate = meetUpDate;
        this.place = place;
        this.owner = owner;
    }

    public ObjectId getId() {
        return id;
    }

    protected void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    protected void setDescription(String description) {
        this.description = description;
    }

    public DateTime getMeetUpDate() {
        return meetUpDate;
    }

    protected void setMeetUpDate(DateTime meetUpDate) {
        this.meetUpDate = meetUpDate;
    }

    public Place getPlace() {
        return place;
    }

    protected void setPlace(Place place) {
        this.place = place;
    }

    public User getOwner() {
        return owner;
    }

    protected void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", meetUpDate=" + meetUpDate +
                ", place=" + place +
                ", owner=" + owner +
                '}';
    }
}
