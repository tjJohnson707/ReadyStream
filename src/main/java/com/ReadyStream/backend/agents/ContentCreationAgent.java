package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class ContentCreationAgent {
    public String createContent(String platform) {
        return "Generated content for " + platform;
    }
}
