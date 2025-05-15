package com.ReadyStream.backend.bots;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BotFactory {

    private final Map<String, Bot> bots;

    @Autowired
    public BotFactory(InstagramBot instagramBot,
                      TwitterBot twitterBot,
                      FaceBookBot faceBookBot,
                      TikTokBot tikTokBot,
                      YouTubeBot youTubeBot) {
        this.bots = Map.of(
                "instagram", instagramBot,
                "twitter", twitterBot,
                "facebook", faceBookBot,
                "tiktok", tikTokBot,
                "youtube", youTubeBot
        );
    }

    public Bot getBot(String platform) {
        Bot bot = bots.get(platform.toLowerCase());
        if (bot == null) {
            throw new IllegalArgumentException("Unsupported platform: " + platform);
        }
        return bot;
    }
}

