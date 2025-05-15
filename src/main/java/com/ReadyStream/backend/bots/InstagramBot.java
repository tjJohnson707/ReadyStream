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

    public InstagramBot(ContentCreationAgent c, EditAgent e, PostAgent p,
                        PromotionAgent promo, EngagementAgent engage, AnalyticsAgent analytics) {
        this.contentCreationAgent = c;
        this.editAgent = e;
        this.postAgent = p;
        this.promotionAgent = promo;
        this.engagementAgent = engage;
        this.analyticsAgent = analytics;
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

        logger.info("📸 Posting to Instagram: {}", content);
        // You can integrate actual APIs later
    }

    public void postToInstagram() {
    }
}

