package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class AnalyticsAgent {
    public static String report(String platform) {
        System.out.println("Reporting analytics for " + platform);
        return platform;
    }
}