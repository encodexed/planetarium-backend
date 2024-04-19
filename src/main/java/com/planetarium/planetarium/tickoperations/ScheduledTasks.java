package com.planetarium.planetarium.tickoperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    // CRON: seconds (0-59), minutes (0-59), hours (0-23), day of month (1-31), month (1-12, or JAN-DEC), day of week (1-7, or SUN-SAT)
    @Autowired
    private TickOperationsService tickOperationsService;

    @Scheduled(cron = "0 0 * * * *")
    public void execute() {
        tickOperationsService.runsEveryHour();
    }

}
