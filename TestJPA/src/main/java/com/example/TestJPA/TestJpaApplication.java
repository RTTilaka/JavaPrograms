package com.example.TestJPA;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TestJpaApplication.class, args);
		MessageService cs = context.getBean(MessageService.class);
		
		cs.insertMessage(0,"Welcome to rvce");
		List<Message> cl=cs.displayMessage();
		
		for(Message m:cl) {
			System.out.println(m);
		}
	}

}
