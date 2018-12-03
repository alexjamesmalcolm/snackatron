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

    @SuppressWarnings("unused")
    private Servant() {}

    Servant(String name) {
        this.name = name;
    }

    public Instant getLastService() {
        return lastService;
    }

    long getId() {
        return id;
    }

    void updateMostRecentService() {
        lastService = Instant.now();
    }

    String getName() {
        return name;
    }
}
