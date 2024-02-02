package vtr18;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

@SuppressWarnings("deprecation")
public class Student_Main {
	
	SessionFactory sc = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	//SessionFactory sc = new Configuration().configure("/path/to/hibernate.cfg.xml").buildSessionFactory();
	Session session = sc.openSession();
	Transaction t = session.beginTransaction();
	
	public void insert(int id,String usn,String name,String address,int totalmarks) {
		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAddress(address);
		s.setUsn(usn);
		session.save(s);
		t.commit();
	}
	
	public void delete(String usn) {
		Query q = session.createQuery("delete from Student where usn=:usn");
		q.setParameter("usn",usn);
		int status = q.executeUpdate();
		if(status == 0) {
			System.out.println(usn + "Deleted Successfully");
		}else {
			System.out.println(usn + "not found");
		}
	}
	
	public void display() {
		Query q = session.createQuery("from Student");
		List l = q.getResultList();
		Iterator it = l.iterator();
		System.out.println("List of Students");
		while(it.hasNext()) {
			Student s = (Student)it.next();
			System.out.println(s.toString());
			}
		}
	
	public void search(String usn) {
		Query q = session.createQuery("from Student where usn = :usn");
		q.setParameter("usn", usn);
		List l = q.getResultList();
		if(l.isEmpty()) {
			System.out.println("Not Found");
		}else {
			Iterator it = l.iterator();
			System.out.println("Student Deatils");
			while(it.hasNext()) {
				Student s = (Student) it.next();
				System.out.println(s.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		Student_Main sm = new Student_Main();
		Scanner sc = new Scanner(System.in);
		
		lp:while(true) {
			System.out.println("1:Insert");
			System.out.println("2:Delete");
			System.out.println("3:Search");
			System.out.println("4:Display");
			System.out.println("7:Exit");
			System.out.println("Make Your Choice");
			int ch = sc.nextInt();
			switch(ch) {
			
			case 1:
				System.out.print("Enter the Student Details to insert \n");
				System.out.print("Enter the Student id \n");
				int id = sc.nextInt();
				System.out.print("Enter the Student usn \n");
				String usn = sc.next();
				System.out.print("Enter the Student name \n");
				String name = sc.next();
				System.out.print("Enter the Student address \n");
				String add = sc.next();
				System.out.println("Enter the Student totalMarks \n");
				int tm = sc.nextInt();
				sm.insert(id, usn, name, add, tm);
				break;
				
			case 2:
				System.out.print("Enter student id to delete\n");
				System.out.print("Enter the Student id \n");
				usn = sc.next();
				sm.delete(usn);
				break;
				
			case 3:
				System.out.print("Enter student id to search\n");
				System.out.print("Enter the Student id \n");
				usn = sc.next();
				sm.search(usn);
				break;
				
			case 4:
				sm.display();
				break;
				
			case 7:
				break lp;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
	
}
