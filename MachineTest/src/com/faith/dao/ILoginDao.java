package com.faith.dao;

import java.util.List;

import com.faith.model.Login;



public interface ILoginDao {
	public abstract List<Login> getAllDetails();
	public abstract Login searchUserDetails(String username,String password);
	public abstract Login getUserById(int uId);
	
	//public abstract int disableUser(int uId);
	
	public abstract int insertUserDetails(Login login);
	
	public abstract int updateUserDetails(Login login);
	

}

