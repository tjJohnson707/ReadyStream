package com.ReadyStream.backend;

import com.ReadyStream.backend.agents.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private final ContentCreationAgent contentCreationAgent;
    private final EditAgent editAgent;
    private final PostAgent postAgent;
    private final PromotionAgent promotionAgent;
    private final EngagementAgent engagementAgent;
    private final AnalyticsAgent analyticsAgent;

    @Autowired
    public AgentController(ContentCreationAgent contentCreationAgent,
                           EditAgent editAgent,
                           PostAgent postAgent,
                           PromotionAgent promotionAgent,
                           EngagementAgent engagementAgent,
                           AnalyticsAgent analyticsAgent) {
        this.contentCreationAgent = contentCreationAgent;
        this.editAgent = editAgent;
        this.postAgent = postAgent;
        this.promotionAgent = promotionAgent;
        this.engagementAgent = engagementAgent;
        this.analyticsAgent = analyticsAgent;
    }

    @GetMapping("/content/create/{platform}")
    public String createContent(@PathVariable String platform) {
        return contentCreationAgent.createContent(platform);
    }

    @PostMapping("/content/edit")
    public String editContent(@RequestBody String content) {
        return editAgent.editContent(content);
    }

    @PostMapping("/content/promote/{platform}")
    public String promoteContent(@PathVariable String platform, @RequestBody String content) {
        return promotionAgent.promoteContent(platform, content);
    }

    @PostMapping("/content/post/{platform}")
    public String postToPlatform(@PathVariable String platform, @RequestBody String content) {
        postAgent.postToPlatform(platform, content);
        return "Posted to " + platform;
    }

    @PostMapping("/engage/{platform}")
    public String engage(@PathVariable String platform) {
        engagementAgent.engage(platform);
        return "Engaged on " + platform;
    }

    @GetMapping("/analytics/{platform}")
    public String report(@PathVariable String platform) {
        return AnalyticsAgent.report(platform);
    }
}
