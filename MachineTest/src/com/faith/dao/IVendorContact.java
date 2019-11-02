package com.faith.dao;

import java.util.List;

import com.faith.model.VendorContact;

public interface IVendorContact {
	
	public abstract List<VendorContact> getAllVendors();
	
	public abstract int insertVendorContactDet(VendorContact vendorContact);

	public abstract int disableVendor(int vId);

	public abstract int updateVendor(VendorContact vendorContact);

	public abstract List<VendorContact> searchVendor(String searchString);

	public abstract VendorContact getVendorById(int vId);
	
	public abstract VendorContact duplication(String phone, String email);

}

