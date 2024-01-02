package com.example.Program2;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Program2Application {

	public static void main(String[] args) {
		SpringApplication.run(Program2Application.class, args);
		
		Scanner sc = new Scanner(System.in);
		ApplicationContext ac = new ClassPathXmlApplicationContext("testBoot.xml");
		
		Department d = (Department)ac.getBean("department");
		
		while(true) {
			System.out.println("1.Insert \n2.Display \n3.Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Insert department details");
				System.out.print("Name: ");
				d.setDept_name(sc.next());
				System.out.print("Id: ");
				d.setDept_id(sc.nextInt());
				sc.nextLine(); 
				System.out.print("Description: ");
				d.setDept_description(sc.nextLine());
				break;
			case 2:
				System.out.println("College details");
				College c=d.getCollege();
				System.out.print("  College_name: "+c.getName());
				System.out.println("  College_address: "+c.getAddress());
				System.out.println("Department details");
				System.out.print("  Id: "+d.getDept_id());
				System.out.print("  Name: "+d.getDept_name());
				System.out.println("  Description: "+d.getDept_description());
				break;
			case 3:
				System.out.println("Exiting.....");
				System.exit(0);
			default:
				sc.close();
				((ClassPathXmlApplicationContext)ac).close();
				System.out.println("Invalid input!!!!");
			}
		}
	}

}
