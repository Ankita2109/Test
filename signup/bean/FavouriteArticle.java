package com.cts.signup.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article_favourite")
public class FavouriteArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="af_id")
	private int id;
	
	

	@Column(name="af_title")
	private String title;
    
	@Column(name="af_description")
	private String description;
	
	
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="af_la_id")
	private Language language;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	
	public FavouriteArticle() {
		super();
	}

	@Override
	public String toString() {
		return "FavouriteArticle [id=" + id + ", title=" + title + ", description=" + description + ", language="
				+ language + "]";
	}

	
}
