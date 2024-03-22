package com.example.Program3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	List<Product>list=new ArrayList<>();
	
	@GetMapping("/hello")
	public String helloworld() {
	return "hello World";
	}
	@GetMapping("/default")
	public Product defaultProduct() {
		Product p=new Product();
		p.setId(1);
		p.setName("pc");
		p.setPrice(1000);
		
		list.add(p);
		
		return p;
		
		}
	
	@GetMapping("/list")
	public List<Product> listProduct(){
		return list;
	}
	
	@PostMapping("/post")
	public Product addProduct(@RequestBody Product product) {
		list.add(product);
		return product;
	}
}