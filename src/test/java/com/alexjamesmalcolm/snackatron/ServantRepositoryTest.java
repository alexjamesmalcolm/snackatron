package com.alexjamesmalcolm.snackatron;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServantRepositoryTest {

    @Resource
    private ServantRepository underTest;

    @Resource
    private TestEntityManager em;

    @Test
    public void shouldSaveServant() {
        underTest.save(new Servant(""));
    }

    @Test
    public void shouldSaveTwoServantsAndRetrieveThem() {
        Servant jim = new Servant("Jim");
        Servant joey = new Servant("Joey");
        jim = underTest.save(jim);
        long jimId = jim.getId();
        joey = underTest.save(joey);
        long joeyId = joey.getId();
        em.flush();
        em.clear();
        assertThat(underTest.findById(jimId).get().getId(), is(jimId));
        assertThat(underTest.findById(joeyId).get().getId(), is(joeyId));
    }

    @Test
    public void shouldRetrieveJimFirstSinceHeHasServedTheEarliest() throws InterruptedException {
        Servant jim = new Servant("Jim");
        Servant joey = new Servant("Joey");
        jim.updateMostRecentService();
        Thread.sleep(1);
        joey.updateMostRecentService();
        underTest.save(jim);
        underTest.save(joey);
        em.flush();
        em.clear();
        List<Servant> servants = underTest.findAllByOrderByLastServiceAsc();
        Servant firstServant = servants.get(0);
        assertThat(firstServant.getName(), is("Jim"));
    }

    @Test
    public void shouldRetrieveJoeyFirstSinceHeHasServedTheEarliest() throws InterruptedException {
        Servant jim = new Servant("Jim");
        Servant joey = new Servant("Joey");
        joey.updateMostRecentService();
        Thread.sleep(1);
        jim.updateMostRecentService();
        underTest.save(jim);
        underTest.save(joey);
        em.flush();
        em.clear();
        List<Servant> servants = underTest.findAllByOrderByLastServiceAsc();
        Servant firstServant = servants.get(0);
        assertThat(firstServant.getName(), is("Joey"));
    }
}
