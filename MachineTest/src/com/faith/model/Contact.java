package com.faith.model;

public class Contact {
	
	private Integer cId;
	private String name;
	private String department;
	private String email;
	private Long phone;
	private Integer vId;
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(Integer cId, String name, String department, String email, Long phone, Integer vId) {
		super();
		this.cId = cId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phone = phone;
		this.vId = vId;
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
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Integer getvId() {
		return vId;
	}
	public void setvId(Integer vId) {
		this.vId = vId;
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", name=" + name + ", department=" + department + ", email=" + email + ", phone="
				+ phone + ", vId=" + vId + "]";
	}
	
	
	

}

