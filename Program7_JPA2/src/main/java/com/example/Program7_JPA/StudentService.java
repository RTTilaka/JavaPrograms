package com.example.Program7_JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepo sr;
	
	public void insertStudent(String name,String address,String usn,int totalmarks) {
		Student s = new Student();
		s.setAddress(address);
		s.setTotalmarks(totalmarks);
		s.setName(name);
		s.setUsn(usn);
		sr.save(s);
	}
	
	public List<Student> display(){
		return sr.findAll();
	}

	public void remove(int id) {
		// TODO Auto-generated method stub	
		Optional<Student> s =sr.findById(id);
		if(s.isPresent()){
			sr.deleteById(id); 		
		}else {
			System.out.println("not found by id"+id);
		}
	}	
}