package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class EngagementAgent {
    public void engage(String platform) {
        System.out.println("Engaging with users on " + platform);
    }
}
