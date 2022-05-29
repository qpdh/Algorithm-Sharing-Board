package org.tukorea.free.domain;


import java.util.Date;


public class PostVO {
	private Integer id;

	private String title;
	private String description;
	private Date postDate;

	// Foreign Keys
	private String language;
	private String userId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PostVO [id=" + id + ", title=" + title + ", description=" + description + ", postDate=" + postDate
				+ ", language=" + language + ", userId=" + userId + "]";
	}
	public PostVO(String title, String description, Date postDate, String language, String userId) {
		super();
		this.title = title;
		this.description = description;
		this.postDate = postDate;
		this.language = language;
		this.userId = userId;
	}
	public PostVO() {
		super();
	}
	
	

}
