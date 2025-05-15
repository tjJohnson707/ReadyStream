package com.ReadyStream.backend.bots;

import com.ReadyStream.backend.agents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class YouTubeBot implements Bot {
    private static final Logger logger = LoggerFactory.getLogger(YouTubeBot.class);
    private final ContentCreationAgent contentCreationAgent;
    private final EditAgent editAgent;
    private final PostAgent postAgent;
    private final PromotionAgent promotionAgent;
    private final EngagementAgent engagementAgent;
    private final AnalyticsAgent analyticsAgent;

    public YouTubeBot(ContentCreationAgent c, EditAgent e, PostAgent p,
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
        String gen = contentCreationAgent.createContent("YouTube");
        String edit = editAgent.editContent(gen);
        String promo = promotionAgent.promoteContent("YouTube", edit);
        postAgent.postToPlatform("YouTube", promo);
        engagementAgent.engage("YouTube");
        analyticsAgent.report("YouTube");
    }
}


