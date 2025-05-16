package com.ReadyStream.backend.bots;

import com.ReadyStream.backend.agents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InstagramBot implements Bot {

    private static final Logger logger = LoggerFactory.getLogger(InstagramBot.class);

    private final ContentCreationAgent contentCreationAgent;
    private final EditAgent editAgent;
    private final PostAgent postAgent;
    private final PromotionAgent promotionAgent;
    private final EngagementAgent engagementAgent;
    private final AnalyticsAgent analyticsAgent;

    public InstagramBot() {
        this.contentCreationAgent = new ContentCreationAgent();
        this.editAgent = new EditAgent();
        this.postAgent = new PostAgent();
        this.promotionAgent = new PromotionAgent();
        this.engagementAgent = new EngagementAgent();
        this.analyticsAgent = new AnalyticsAgent();
    }

    // Explicit call method, could be triggered via API or internally
    public void postToInstagram() {
        String content = contentCreationAgent.createContent("Instagram");
        String edited = editAgent.editContent(content);
        String promo = promotionAgent.promoteContent("Instagram", edited);
        postAgent.postToPlatform("Instagram", promo);
        engagementAgent.engage("Instagram");
        analyticsAgent.report("Instagram");

        logger.info("📸 Posting to Instagram: {}", promo);
    }

    @Override
    public void post(String content) {
        String gen = contentCreationAgent.createContent("Instagram");
        String edit = editAgent.editContent(gen);
        String promo = promotionAgent.promoteContent("Instagram", edit);
        postAgent.postToPlatform("Instagram", promo);
        engagementAgent.engage("Instagram");
        analyticsAgent.report("Instagram");
        logger.info("Posted to Instagram: {}", promo);
    }
}


