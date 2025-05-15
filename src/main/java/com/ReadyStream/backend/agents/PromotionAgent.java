package com.ReadyStream.backend.agents;

import org.springframework.stereotype.Component;

@Component
public class PromotionAgent {
    public String promoteContent(String platform, String content) {
        return content + " [Promoted on " + platform + "]";
    }
}
