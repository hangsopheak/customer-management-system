package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	
	private int id;
	private String firstname;
	private String lastname;
	private String gender;
	private String email;
	private String phone;
	private String address;
	private Date dob;
	private Date createdDate;
	private Date updatedDate;
	
	public Customer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}
	
	public String getDobToString(){
		if(this.createdDate != null) return (new SimpleDateFormat("yyyy-MM-dd")).format(this.dob);
		else return "";
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setDobFromString(String dob) throws ParseException{
		if(dob != null) this.setDob((new SimpleDateFormat("yyyy-MM-dd")).parse(dob));
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public String getCreatedDateToString(){
		if(this.createdDate != null) return (new SimpleDateFormat("yyyy-MM-dd H:m:s")).format(this.createdDate);
		else return "";
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public void setCreatedDateFromString(String createdDate) throws ParseException{
		if(createdDate != null) this.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd H:m:s")).parse(createdDate));
	}
	
	public Date getUpdatedDate() {
		return updatedDate;
	}
	
	public String getUpdatedDateToString(){
		if(this.updatedDate != null) return (new SimpleDateFormat("yyyy-MM-dd H:m:s")).format(this.updatedDate);
		else return "";
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public void setUpdatedDateFromString(String updatedDate) throws ParseException{
		if(updatedDate != null) this.setCreatedDate((new SimpleDateFormat("yyyy-MM-dd H:m:s")).parse(updatedDate));
	}
	
	public String getActionButtons(){
		return "<a data-id='"+this.id+"' class='edit' style='margin-right:10px; cursor:pointer' role='button'><i class='glyphicon glyphicon-pencil'></i></a>"
				+ "<a data-id='"+this.id+"' class='delete' style='cursor:pointer;' ><i class='glyphicon glyphicon-remove ' style='color:red'></i></a>";
	}
	

}
