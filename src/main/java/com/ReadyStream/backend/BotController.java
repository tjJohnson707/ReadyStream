package com.ReadyStream.backend;

import com.ReadyStream.backend.bots.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bots")
public class BotController {

    private final InstagramBot instagramBot;
    private final TwitterBot twitterBot;
    private final FaceBookBot facebookBot;
    private final TikTokBot tiktokBot;
    private final YouTubeBot youtubeBot;

    @Autowired
    public BotController(InstagramBot instagramBot,
                         TwitterBot twitterBot,
                         FaceBookBot facebookBot,
                         TikTokBot tiktokBot,
                         YouTubeBot youtubeBot) {
        this.instagramBot = instagramBot;
        this.twitterBot = twitterBot;
        this.facebookBot = facebookBot;
        this.tiktokBot = tiktokBot;
        this.youtubeBot = youtubeBot;
    }

    @PostMapping("/{platform}/post")
    public String postContent(@PathVariable String platform, @RequestBody String content) {
        switch (platform.toLowerCase()) {
            case "instagram":
                instagramBot.post(content);
                break;
            case "twitter":
                twitterBot.post(content);
                break;
            case "facebook":
                facebookBot.post(content);
                break;
            case "tiktok":
                tiktokBot.post(content);
                break;
            case "youtube":
                youtubeBot.post(content);
                break;
            default:
                return "❌ Unsupported platform: " + platform;
        }
        return "✅ Content posted to " + platform;
    }
}
