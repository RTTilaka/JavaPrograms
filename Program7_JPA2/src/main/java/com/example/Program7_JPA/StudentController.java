package com.example.Program7_JPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService ss;
	
	@GetMapping("/get")
	public List<Student> display(){
		return ss.display();
	}
	
	@PostMapping("/post")
	public void insertStudent(@RequestBody Student s) {
		ss.insertStudent(s.getName(),s.getAddress(),s.getUsn(),s.getTotalmarks());
		System.out.println(" inserted successfully");	
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable int id ) {
		ss.remove(id);	
	}
}
