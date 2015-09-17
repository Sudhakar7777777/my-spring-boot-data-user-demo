package org.sbk.demo.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class UserProfile {

	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String city;
	private String state;
	private String postal_code;
	private String create_time;
	private String update_time;
	
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + ", city=" + city + ", state=" + state
				+ ", postal_code=" + postal_code + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}

	public UserProfile() {
		//Do Nothing: Need to support POST Requests
	}

	public UserProfile(String firstName, String lastName, String email,
			String address, String city, String state, String postal_code,
			String create_time, String update_time) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postal_code = postal_code;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
}
