package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendorContact;
import com.faith.model.VendorContact;


@CrossOrigin
@RestController
@RequestMapping("/api")

public class VendorController {
	
	@Autowired
	private IVendorContact dao;
	
	@RequestMapping(value="/vendordetails",method = RequestMethod.GET)
	public List getUserDetails(){
		List list;
		System.out.println("Getting the details");
		list = dao.getAllVendors();
		return list;
	}	
	
	@RequestMapping(value = "/vendorbyid/{vnId}", method = RequestMethod.GET)
	public VendorContact getvendorDetails(@PathVariable("vnId") int vnId){
		
		VendorContact vendorContact = (VendorContact) dao.getVendorById(vnId);
		return vendorContact;
	}
	
	 //insert  vendor and contact details
	@RequestMapping(value = "/insertvendor", method =RequestMethod.POST)
	public void insertDetails(@RequestBody VendorContact vendorContact)
	{
			dao.insertVendorContactDet(vendorContact);
	}
	
	//update vendor and contact details
	@RequestMapping(value = "/updatevendor/{vnId}", method = RequestMethod.PUT)
	public void updateVendor(@RequestBody VendorContact vendorContact)
	{
		dao.updateVendor(vendorContact);
	}
	
	
	//disable 
	@RequestMapping(value = "/disablevendor/{vnId}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vnId") int vnId) {
		dao.disableVendor(vnId);
	}
	
	//duplication check
	
	@RequestMapping(value="/duplication/{phone}/{email}",method = RequestMethod.GET)
	public VendorContact duplication(@PathVariable(value="phone")String phone,
			@PathVariable(value="email")String email){
		VendorContact vendorContact= (VendorContact)dao.duplication(phone,email);
		return vendorContact;
		
	}

}

