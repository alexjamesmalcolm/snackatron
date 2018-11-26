package com.alexjamesmalcolm.snackatron;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Servant {

    @Id
    @GeneratedValue
    private long id;

    private Instant lastService;

    private String name;

    private Servant() {}

    public Servant(String name) {
        this.name = name;
    }

    public Instant mostRecentService() {
        return null;
    }

    public long getId() {
        return id;
    }

    public void updateMostRecentService() {
        lastService = Instant.now();
    }

    public String getName() {
        return name;
    }
}
