package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.ILoginDao;
import com.faith.model.Login;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private ILoginDao dao;
	
	@RequestMapping(value="/logindetails",method = RequestMethod.GET)
	public List getUserDetails(){
		List list;
		System.out.println("Getting the details");
		list = dao.getAllDetails();
		return list;
	}	
	
	@RequestMapping(value="/login/{username}/{password}",method = RequestMethod.GET)
	public Login searchUserDetails(@PathVariable(value="username")String username, @PathVariable(value="password") 
	String password){
		Login login= (Login)dao.searchUserDetails(username,password);
		return login;
		
	}


	@RequestMapping(value="/loginById/{uId}",method = RequestMethod.GET)
	public Login getUserByID(@PathVariable("uId")int uId ){
		
		System.out.println("Getting single user details");
		Login login = (Login)dao.getUserById(uId);
		return login;
	}
	@RequestMapping(value="/insertlogin",method = RequestMethod.POST)
	public void insertDetails(@RequestBody Login login){
			dao.insertUserDetails(login);
	}
	
	@RequestMapping(value="/updatelogin",method = RequestMethod.PUT)
	public void updateDetails(@RequestBody Login login){
			dao.updateUserDetails(login);
	}
}

