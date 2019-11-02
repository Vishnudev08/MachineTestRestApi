package com.faith.model;

public class Vendor {
	
	private Integer vnId;
	private String vnName;
	private String vnAddress;
	private String vnLocation;
	private String vnService;
	private Integer vnPincode;
	private String isActive;
	
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(Integer vnId, String vnName, String vnAddress, String vnLocation, String vnService, Integer vnPincode,
			String isActive) {
		super();
		this.vnId = vnId;
		this.vnName = vnName;
		this.vnAddress = vnAddress;
		this.vnLocation = vnLocation;
		this.vnService = vnService;
		this.vnPincode = vnPincode;
		this.isActive = isActive;
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
	public Integer getVnPincode() {
		return vnPincode;
	}
	public void setVnPincode(Integer vnPincode) {
		this.vnPincode = vnPincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Vendor [vnId=" + vnId + ", vnName=" + vnName + ", vnAddress=" + vnAddress + ", vnLocation=" + vnLocation
				+ ", vnService=" + vnService + ", vnPincode=" + vnPincode + ", isActive=" + isActive + "]";
	}
	
	
	
	
}




