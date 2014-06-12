package sample.domain;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User implements Serializable {

    @Id
    private ObjectId objectId;
    private String name;
    private String email;

    protected User() {
        //spring data
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    protected void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    protected void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "objectId=" + objectId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
