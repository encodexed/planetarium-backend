package com.planetarium.planetarium.tickoperations;

import com.planetarium.planetarium.stars.Star;

public class TickUtilities {
    public static void generateHourlyReport(Star star) {
        System.out.printf("The newest star to be created is %s, discovered at %s", star.getName(), star.getDateInstantiated());
    }
}
