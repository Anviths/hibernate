package edu.ty.use.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import edu.ty.socialmedia.model.SocialMedia;

@Entity
public class User1 {

	@Id
	private int userId;
	private String userName;
	private String userEmail;
	private long userPhone;
	private String userPassword;
	@ManyToMany
	private List<SocialMedia> socialMedia;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public List<SocialMedia> getSocialMedia() {
		return socialMedia;
	}

	public void setSocialMedia(List<SocialMedia> socialMedia) {
		this.socialMedia = socialMedia;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userPassword=" + userPassword + ", socialMedia=" + socialMedia + "]";
	}
	
	
	
}
