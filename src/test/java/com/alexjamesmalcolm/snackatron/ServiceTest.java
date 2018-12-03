package com.alexjamesmalcolm.snackatron;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ServiceTest {

    @Mock
    Servant servant;

    @Mock
    Servant anotherServant;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldHaveDate() {
        Date date = Date.from(Instant.now());
        Service underTest = new Service(date);
        Date actual = underTest.getDate();
        assertThat(actual, is(date));
    }

    @Test
    public void shouldGetServants() {
        Service underTest = new Service(null, servant);
        Set<Servant> servants = underTest.getServants();
        assertThat(servants.contains(servant), is(true));
    }
}
