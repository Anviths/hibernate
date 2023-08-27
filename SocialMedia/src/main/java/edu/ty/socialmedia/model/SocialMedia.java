package edu.ty.socialmedia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocialMedia {

	@Id
	private int socialId;
	private String socialMediaName;
	private int foundedYear;
	private String headQuaters;
	public int getSocialId() {
		return socialId;
	}
	public void setSocialId(int socialId) {
		this.socialId = socialId;
	}
	public String getSocialMediaName() {
		return socialMediaName;
	}
	public void setSocialMediaName(String socialMediaName) {
		this.socialMediaName = socialMediaName;
	}
	public int getFoundedYear() {
		return foundedYear;
	}
	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}
	public String getHeadQuaters() {
		return headQuaters;
	}
	public void setHeadQuaters(String headQuaters) {
		this.headQuaters = headQuaters;
	}
	@Override
	public String toString() {
		return "SocialMedia [socialId=" + socialId + ", socialMediaName=" + socialMediaName + ", foundedYear="
				+ foundedYear + ", headQuaters=" + headQuaters + "]";
	}
	
	
}
