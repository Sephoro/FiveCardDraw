package com.epiuse.poker;

import com.epiuse.poker.config.CustomBanner;
import com.epiuse.poker.service.interfaces.PokerPlayService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokerApplication {

	@Autowired
	@Qualifier("FiveCardPokerPlayService")
	private PokerPlayService fiveCardPokerPlayService;
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PokerApplication.class);
		application.setBanner(new CustomBanner());
		application.run(args);
	}

	@PostConstruct
	public void playGame(){
		fiveCardPokerPlayService.play();
	}

}
