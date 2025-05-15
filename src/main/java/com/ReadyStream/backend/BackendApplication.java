package com.ReadyStream.backend;

import com.ReadyStream.backend.agents.ContentCreationAgent;
import com.ReadyStream.backend.bots.InstagramBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		ContentCreationAgent agent = new ContentCreationAgent();
		agent.createContent();

		InstagramBot bot = new InstagramBot();
		bot.postToInstagram();
	}
}

