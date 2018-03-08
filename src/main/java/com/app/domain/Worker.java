package com.app.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Worker {
	private int rating;
	private boolean isActive;
	private List<String> certificates;
	private List skills;
	private JobSearchAddress jobSearchAddress;
	private List<Availability> availability;
	private String phone;
	private String email;
	private Name name;
	private long age;
	private String guid;
	private long userId;
	private String transportation;
	private boolean hasDriversLicense;
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<String> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}
	public List getSkills() {
		return skills;
	}
	public void setSkills(List skills) {
		this.skills = skills;
	}
	public JobSearchAddress getJobSearchAddress() {
		return jobSearchAddress;
	}
	public void setJobSearchAddress(JobSearchAddress jobSearchAddress) {
		this.jobSearchAddress = jobSearchAddress;
	}
	public List<Availability> getAvailability() {
		return availability;
	}
	public void setAvailability(List<Availability> availability) {
		this.availability = availability;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public boolean isHasDriversLicense() {
		return hasDriversLicense;
	}
	public void setHasDriversLicense(boolean hasDriversLicense) {
		this.hasDriversLicense = hasDriversLicense;
	}
	
	@Override
	public String toString() {
		return "Worker [rating=" + rating + ", isActive=" + isActive + ", certificates=" + certificates + ", skills="
				+ skills + ", jobSearchAddress=" + jobSearchAddress + ", availability=" + availability + ", phone="
				+ phone + ", email=" + email + ", name=" + name + ", age=" + age + ", guid=" + guid + ", userId="
				+ userId + ", transportation=" + transportation + ", hasDriversLicense=" + hasDriversLicense + "]";
	}
	

	
	
}
