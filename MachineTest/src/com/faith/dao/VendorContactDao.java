package com.faith.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.VendorContact;

public class VendorContactDao implements IVendorContact{
	
	  //setting Jdbc template
			JdbcTemplate template;
			public void setTemplate(JdbcTemplate template) {
			this.template = template;
			}

	@Override
	public List<VendorContact> getAllVendors() {
		
		    	return template.query("select v.vnId,v.vnName,v.vnAddress,v.vnLocation,v.vnService,"
		    			+ "c.Name,c.department,c.phone from vendorTable v join contactTable c "
		    			+ "on(v.vnId=c.vnId) where isActive='Y' order by v.vnId desc",
								new RowMapper<VendorContact>() {
									public VendorContact mapRow(ResultSet rs, int row)
											throws SQLException {
										VendorContact vendorContact = new VendorContact();
										vendorContact.setVnId(rs.getInt(1));
										vendorContact.setVnName(rs.getString(2));
										vendorContact.setVnAddress(rs.getString(3));
										vendorContact.setVnLocation(rs.getString(4));
										vendorContact.setVnService(rs.getString(5));
										vendorContact.setName(rs.getString(6));
										vendorContact.setDepartment(rs.getString(7));
										vendorContact.setPhone(rs.getString(8));
										return vendorContact;
									}
								});
		    }
	

	@Override
	public int insertVendorContactDet(VendorContact vendorContact) {
		
		//insert data only to vendorTable 
		String sqlOne="insert into vendorTable(vnName,vnAddress,vnLocation,vnService, "
				+ "vnpincode,isActive) values('"+
				vendorContact.getVnName()+"','"+
				vendorContact.getVnAddress()+"','"+
				vendorContact.getVnLocation()+"','"+
				vendorContact.getVnService()+"',"+
				vendorContact.getVnPincode()+",'Y')";
		template.update(sqlOne);
		
		//get maximum of vendor id from vendorTable
		Integer maxVnId=getMaxVnId();
			
		//insert data only to vendorTable with Vendor Id
		String sqlTwo="insert into contactTable(Name,department,email,phone,vnId) "
				+ "values('"+vendorContact.getName()+"','"+
				vendorContact.getDepartment()+"','"+
				vendorContact.getEmail()+"','"+
				vendorContact.getPhone()+"',? )";
		return template.update(sqlTwo,new Object[] {maxVnId});		
	}
	
	//function for fetching maximum value of vendor id from vendor table 
	private Integer getMaxVnId() {
		
		String sql = "select MAX(vnId)from vendorTable";
		Integer maxId = template.queryForObject(sql, new Object[] {}, Integer.class);
		return maxId;
	}
	

	@Override
	public int disableVendor(int vnId) {
		String sql = "update vendorTable set isActive='N' where vnId=?";
		return template.update(sql,new Object[] { vnId });
	}

	@Override
	public int updateVendor(VendorContact vendorContact) {
		// updating vendor table
    	String sqlOne="update vendorTable set vnName='"+vendorContact.getVnName()
    			      +"',vnAddress='"+vendorContact.getVnAddress()+"',vnLocation='"
    			      +vendorContact.getVnLocation()+"',vnService='"
    			      +vendorContact.getVnService()+"',vnpincode="+
    			      vendorContact.getVnPincode()+" where vnId=?";
    	template.update(sqlOne,new Object[] {vendorContact.getVnId()});
    	
    	//updating contact table
    	String sqlTwo="update contactTable set Name='"+vendorContact.getName()
    			      +"',department='"+vendorContact.getDepartment()
    			      +"',email='"+vendorContact.getEmail()+"',phone='"
    			      +vendorContact.getPhone()+"' where vnId=?";
    	
    	return template.update(sqlTwo,new Object[] {vendorContact.getVnId()});
	}

	@Override
	public List<VendorContact> searchVendor(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VendorContact getVendorById(int vnId) {
		String sql = "select v.vnId,v.vnName,v.vnLocation,v.vnService,v.vnAddress,v.Vnpincode,c.Name,"
    			+ "c.department,c.phone,c.email from vendorTable v join contactTable c"
    			+ " on(v.vnId=c.vnId) where isActive='Y' and v.vnId=?";
		return template.queryForObject(sql, new Object[] {vnId},
				new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
	}
	// duplication check
	@Override
	public VendorContact duplication(String phone, String email) {
		try{
			String sql = "select c.email,c.phone from vendorTable v join contactTable c on(v.vnid=c.vnid) where (c.phone=? or c.email=?) and v.isactive='Y'";
			return template.queryForObject(sql, new Object[] {phone,email},
					new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

}
