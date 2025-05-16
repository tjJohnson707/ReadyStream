package com.ReadyStream.backend;

import com.ReadyStream.backend.bots.Bot;
import com.ReadyStream.backend.bots.BotFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(BotFactory botFactory) {
		return args -> {
			// Example usage: run bots after application starts
			Bot instagramBot = botFactory.getBot("instagram");
			instagramBot.post("New product launch post for Instagram!");

			Bot twitterBot = botFactory.getBot("twitter");
			twitterBot.post("Announcing our launch on Twitter 🚀");

			Bot facebookBot = botFactory.getBot("facebook");
			facebookBot.post("Launching now on Facebook! 🎉");

			Bot tiktokBot = botFactory.getBot("tiktok");
			tiktokBot.post("🎵 Check out our launch video on TikTok!");

			Bot youtubeBot = botFactory.getBot("youtube");
			youtubeBot.post("📹 Full launch video is live on YouTube!");
		};
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello from BackendApplication";
	}
}
