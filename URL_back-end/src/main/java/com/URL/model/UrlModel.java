package com.URL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UrlsDB")
public class UrlModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String originalUrl;
	@Column
	private String shortUrl;

	
	public UrlModel() {
		super();
	}
	
	
	public UrlModel(String shortUrl, String originalUrl) {
		super();
		this.shortUrl = shortUrl;
		this.originalUrl = originalUrl;
	}

	
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	

}
