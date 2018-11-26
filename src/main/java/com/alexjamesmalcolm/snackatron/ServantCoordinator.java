package com.alexjamesmalcolm.snackatron;

import javax.annotation.Resource;

public class ServantCoordinator {

    @Resource
    private ServantRepository servantRepo;

    public Servant whoHasNotServedRecently() {
//        servants = servantRepo.findAll();
        return null;
    }
}
