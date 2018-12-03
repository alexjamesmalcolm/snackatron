package com.alexjamesmalcolm.snackatron;

import javax.annotation.Resource;

class ServantCoordinator {

    @Resource
    private ServantRepository servantRepo;

    Servant whoHasNotServedRecently() {
        return servantRepo.findFirstByOrderByLastServiceAsc();
    }
}
