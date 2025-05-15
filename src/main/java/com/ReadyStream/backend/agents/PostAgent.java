package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class PostAgent {
    public void postToPlatform(String platform, String content) {
        System.out.println("Posting to " + platform + ": " + content);
    }
}
