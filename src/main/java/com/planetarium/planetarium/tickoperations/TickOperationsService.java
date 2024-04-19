package com.planetarium.planetarium.tickoperations;

import com.planetarium.planetarium.starSystems.StarSystemService;
import com.planetarium.planetarium.stars.Star;
import com.planetarium.planetarium.stars.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TickOperationsService {

    @Autowired
    private StarService starService;

    @Autowired
    private StarSystemService starSystemService;

    public void runsEveryHour() {
        System.out.println("------------------------------------");
        System.out.println("A new hour has begun for the universe. Current time is: " + new Date());
        TickUtilities.generateHourlyReport(this.starService.getLastCreatedStar());
        System.out.println("\n------------------------------------");
    }
}
