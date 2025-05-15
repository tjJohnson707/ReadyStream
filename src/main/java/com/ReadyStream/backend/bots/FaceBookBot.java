package com.ReadyStream.backend.bots;

import com.ReadyStream.backend.agents.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class FaceBookBot implements Bot {

    private static final Logger logger = LoggerFactory.getLogger(FaceBookBot.class); // FIXED: Logger class name

    private final ContentCreationAgent contentCreationAgent;
    private final EditAgent editAgent;
    private final PostAgent postAgent;
    private final PromotionAgent promotionAgent;
    private final EngagementAgent engagementAgent;
    private final AnalyticsAgent analyticsAgent;

    @Autowired // FIXED: Required for Spring to inject dependencies
    public FaceBookBot(ContentCreationAgent contentCreationAgent,
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

    @Override
    public void post(String content) {
        String generated = contentCreationAgent.createContent("Facebook");
        String edited = editAgent.editContent(generated);
        String promoted = promotionAgent.promoteContent("Facebook", edited);
        postAgent.postToPlatform("Facebook", promoted);
        engagementAgent.engage("Facebook");
        analyticsAgent.report("Facebook");

        logger.info("✅ FacebookBot completed posting workflow.");
    }
}


