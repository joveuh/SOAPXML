package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.spring.learningspring.enterprise.data.games.GameRunner;

@SpringBootApplication
public class GameController {
 
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GameController.class, args);

		// SuperContraGame game = new SuperContraGame();
		// GameRunner runner = new GameRunner(game);
		// runner.run();

		// MarioGame game2 = new MarioGame();
		// GameRunner runner2 = new GameRunner(game2);
		// runner2.run();


		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());
	}

}
