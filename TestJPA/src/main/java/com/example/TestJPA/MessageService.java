package com.example.TestJPA;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	MessageRepository mr;
	
	void insertMessage(long id, String message) {
		Message m = new Message();
		m.setId(id);
		m.setMeassage(message);
		mr.save(m);
	}
	
	List<Message> displayMessage(){
		return mr.findAll();
	}
}
