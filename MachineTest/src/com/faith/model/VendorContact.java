package com.faith.model;

public class VendorContact {
	
	private Integer vnId;
	private String vnName;
	private String vnAddress;
	private String vnLocation;
	private String vnService;
	private Double vnPincode; 
	private String isActive;
	
	private Integer cId ;
	private String name ;
	private String department;
	private String email;
	private String phone ;
	
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public VendorContact(Integer vnId, String vnName, String vnAddress, String vnLocation, String vnService,
			Double vnPincode, String isActive, Integer cId, String name, String department, String email,
			String phone) {
		super();
		this.vnId = vnId;
		this.vnName = vnName;
		this.vnAddress = vnAddress;
		this.vnLocation = vnLocation;
		this.vnService = vnService;
		this.vnPincode = vnPincode;
		this.isActive = isActive;
		this.cId = cId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}




	public Integer getVnId() {
		return vnId;
	}

	public void setVnId(Integer vnId) {
		this.vnId = vnId;
	}

	public String getVnName() {
		return vnName;
	}

	public void setVnName(String vnName) {
		this.vnName = vnName;
	}

	public String getVnAddress() {
		return vnAddress;
	}

	public void setVnAddress(String vnAddress) {
		this.vnAddress = vnAddress;
	}

	public String getVnLocation() {
		return vnLocation;
	}

	public void setVnLocation(String vnLocation) {
		this.vnLocation = vnLocation;
	}

	public String getVnService() {
		return vnService;
	}

	public void setVnService(String vnService) {
		this.vnService = vnService;
	}

	public Double getVnPincode() {
		return vnPincode;
	}

	public void setVnPincode(Double vnPincode) {
		this.vnPincode = vnPincode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "VendorContact [vnId=" + vnId + ", vnName=" + vnName + ", vnAddress=" + vnAddress + ", vnLocation="
				+ vnLocation + ", vnService=" + vnService + ", vnPincode=" + vnPincode + ", isActive=" + isActive
				+ ", cId=" + cId + ", Name=" + name + ", department=" + department + ", email=" + email + ", phone="
				+ phone + "]";
	}
	
	
	
	
}


