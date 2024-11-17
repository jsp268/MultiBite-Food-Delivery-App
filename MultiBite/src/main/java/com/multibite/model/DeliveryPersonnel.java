 	package com.multibite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DeliveryPersonnel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer deliverypersonnelId;
	
	@NotNull(message = "First name is mandatory")
	private String firstName;
	
	@NotNull(message = "Last name is mandatory")
	private String lastName;

	@NotNull(message = "availability is mandatory")
    private Boolean available;

	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getDeliverypersonnelId() {
		return deliverypersonnelId;
	}

	public void setDeliverypersonnelId(Integer deliverypersonnelId) {
		this.deliverypersonnelId = deliverypersonnelId;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String gender;
	
	@Size(max = 10,min = 10, message = "Require only 10 digit")
	private String mobileNumber;
	
	@NotNull(message = "Email is mandatory")
	@Email(message = "Require email format")
	private String email;
	
	@NotNull(message = "Password is mandatory")
	private String password;


}