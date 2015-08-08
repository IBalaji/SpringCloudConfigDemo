package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.dao.UserDAO;
import demo.pojo.User;

@RestController
public class DemoController {
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/")
	public String home() {
	    return "Initialized Properties  ";
	}
	
	 @RequestMapping("/insert")
	 public String insertUser() {
		  userDAO.insertUser(new User("First User", "first@gmail.com", "Address", 43));
	      return "User Successfully Inserted";
     }
	
}
