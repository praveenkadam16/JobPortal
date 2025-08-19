package com.portal.jobportal.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job_seeker_profile")
public class JobSeekerProfile {
	@Id
	private int userAccountId;
	// JobSeekerProfile is associated with one user; 
	@OneToOne
	@JoinColumn(name="user_account_id")
	@MapsId
	private Users userId;
	
	private String firstName;
	private String lastName;
	private String city;
	private String country;
	private String workAuthorization;
	private String employmentType;
	private String resume;
	@Column(nullable=true,length =60)
	private String profilePhoto;
	// JobSeekerProfile can have one to many skills
	@OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL,mappedBy = "jobSeekerProfile")
	private List<Skills> skills;
	public JobSeekerProfile() {
		
	}
	public JobSeekerProfile(int userAccountId, Users userId, String firstName, String lastName, String city,
			String country, String workAuthorization, String employmentType, String resume, String profilePhoto,
			List<Skills> skills) {
		super();
		this.userAccountId = userAccountId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.workAuthorization = workAuthorization;
		this.employmentType = employmentType;
		this.resume = resume;
		this.profilePhoto = profilePhoto;
		this.skills = skills;
	}
	public JobSeekerProfile(Users users) {
		this.userId=users;
	}
	public int getUserAccountId() {
		return userAccountId;
	}
	public void setUserAccountId(int userAccountId) {
		this.userAccountId = userAccountId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getWorkAuthorization() {
		return workAuthorization;
	}
	public void setWorkAuthorization(String workAuthorization) {
		this.workAuthorization = workAuthorization;
	}
	public String getEmploymentType() {
		return employmentType;
	}
	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilephoto(String profilephoto) {
		this.profilePhoto = profilePhoto;
	}
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "JobSeekerProfile [userAccountId=" + userAccountId + ", userId=" + userId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", city=" + city + ", country=" + country + ", workAuthorization="
				+ workAuthorization + ", employmentType=" + employmentType + ", resume=" + resume + ", profilePhoto="
				+ profilePhoto + ", skills=" + skills + "]";
	}
	
	

}
