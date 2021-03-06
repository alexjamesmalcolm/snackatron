package com.alexjamesmalcolm.snackatron;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

public class ServantCoordinatorMockTest {

    @Mock
    private ServantRepository servantRepo;

    @Mock
    private Servant jim;

    @Mock
    private Servant john;

    @Mock
    private Servant joey;

    @InjectMocks
    private ServantCoordinator underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Iterable<Servant> servants = asList(jim, john, joey);
        when(servantRepo.findAll()).thenReturn(servants);
    }

    @Test
    public void shouldRetrieveServantWhoHasNotServedRecently() {
        when(servantRepo.findFirstByOrderByLastServiceAsc()).thenReturn(jim);
        Servant actual = underTest.whoHasNotServedRecently();
        assertThat(actual, is(jim));
    }
}
