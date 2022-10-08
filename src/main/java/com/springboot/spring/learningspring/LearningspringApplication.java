package com.springboot.spring.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningspringApplication {

	public static void main(String[] args) {
		// SpringApplication.run(LearningspringApplication.class, args);

		MarioGame game = new MarioGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}

}
