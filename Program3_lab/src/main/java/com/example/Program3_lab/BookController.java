package com.example.Program3_lab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book/bill")
public class BookController {
	
	List<Books>list=new ArrayList<>();
	@GetMapping("/list")
	public List<Books> getBooks() {
		return list;
	}
	@PostMapping("/post")
	public Books addBooks(@RequestBody Books book) {
		list.add(book);
		return book;
	}
}
