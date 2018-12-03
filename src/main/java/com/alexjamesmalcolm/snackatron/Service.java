package com.alexjamesmalcolm.snackatron;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class Service {
    private final Date date;
    private final Set<Servant> servants;

    Service(Date date, Servant...servants) {
        this.date = date;
        this.servants = new HashSet<>(Arrays.asList(servants));
    }

    Date getDate() {
        return date;
    }

    Set<Servant> getServants() {
        return servants;
    }
}
