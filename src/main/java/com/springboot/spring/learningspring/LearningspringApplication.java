package com.springboot.spring.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springboot.spring.learningspring.enterprise.MyWebController;

@SpringBootApplication
public class LearningspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearningspringApplication.class, args);

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
