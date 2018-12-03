package com.alexjamesmalcolm.snackatron;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServantRepository extends CrudRepository<Servant, Long> {
    List<Servant> findAllByOrderByLastServiceAsc();

    Servant findFirstByOrderByLastServiceAsc();
}
