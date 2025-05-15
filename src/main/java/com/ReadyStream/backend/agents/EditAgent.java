package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class EditAgent {
    public String editContent(String content) {
        return "Edited: " + content;
    }
}