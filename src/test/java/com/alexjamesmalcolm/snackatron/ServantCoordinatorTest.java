package com.alexjamesmalcolm.snackatron;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

public class ServantCoordinatorTest {

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
}
