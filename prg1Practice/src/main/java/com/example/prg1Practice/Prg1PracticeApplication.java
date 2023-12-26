package com.example.prg1Practice;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Prg1PracticeApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SpringApplication.run(Prg1PracticeApplication.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
		Customer c = (Customer) ac.getBean("customer");
		Ticket t = (Ticket) c.getTicket();
		while(true) {
    		System.out.println("1. insert the details\n 2. Display details \n"
    				+ "3. exit");
    		System.out.println("enter the choice");
    		int a = sc.nextInt();
    		switch(a) {
	    		case 1: 
	    			System.out.println("enter the customer name");
					c.setName(sc.next());
					System.out.println("enter the customer address");
					c.setAdress(sc.next());
					System.out.println("enter the ticket number");
					t.setTicNo(sc.nextInt());
					System.out.println("enter the ticket seat no");
					t.setSeatNo(sc.nextInt());
					System.out.println("enter the ticket price");
					t.setPrice(sc.nextInt());
					System.out.println("enter the ticket Type - economic/gold/platinum");
					t.setTicType(sc.next());
					c.setTicket(t);
					System.out.println("thanks for input");    		
					break;
	    		case 2: 
	    			System.out.println("Customer Details:");
	    			System.out.println("Name:"+c.getName()+" "+" Address:"+c.getAdress());
	    			System.out.println("Ticket Details");
	    			t = c.getTicket();
	    			System.out.println("Ticket No: "+t.getTicNo());
	    			System.out.println("Ticket Type: "+t.getTicType());
	    			System.out.println("Ticket Seat No: "+t.getSeatNo());
	    			System.out.println("Ticket Price: "+t.getPrice());
	    			break;
	    		case 3: 
	    			System.exit(0); 			
    		}    		
    	}    	
	}
}
