package com.ReadyStream.backend.bots;

import com.ReadyStream.backend.agents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TwitterBot implements Bot {
    private static final Logger logger = LoggerFactory.getLogger(TwitterBot.class);
    private final ContentCreationAgent contentCreationAgent;
    private final EditAgent editAgent;
    private final PostAgent postAgent;
    private final PromotionAgent promotionAgent;
    private final EngagementAgent engagementAgent;
    private final AnalyticsAgent analyticsAgent;

    public TwitterBot(ContentCreationAgent c, EditAgent e, PostAgent p,
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
        String gen = contentCreationAgent.createContent("Twitter");
        String edit = editAgent.editContent(gen);
        String promo = promotionAgent.promoteContent("Twitter", edit);
        postAgent.postToPlatform("Twitter", promo);
        engagementAgent.engage("Twitter");
        analyticsAgent.report("Twitter");
    }
}





