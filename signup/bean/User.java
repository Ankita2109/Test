package com.cts.signup.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")/*
@NamedQueries({
	@NamedQuery(name = "User.fetchUserByEmail",
			query = "select u from User u where u.email= :email")
	
	
})*/
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "name cannot be empty")
	@Size(min = 4, max = 30, message = "Name must be 4 to 30 characters")
	@Column(name = "us_name")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Size(min = 8, max = 30, message = "Email must be 8 to 30 characters")
	@Column(name = "us_email")
	private String email;
	
	@NotNull(message = "Password cannot be empty")
	@Size(min = 4, max = 10, message = "Password must be 4 to 10 characters")
	@Column(name = "us_password")
	private String password;
	
	@Column(name = "us_blacklisted")
	private String blacklisted;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_ro_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "us_la_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Language language;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "article", joinColumns = { @JoinColumn(name = "ar_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ar_af_id") })
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private List<FavouriteArticle> favouriteArticle;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBlacklisted() {
		return blacklisted;
	}

	public void setBlacklisted(String blacklisted) {
		this.blacklisted = blacklisted;
	}

	public List<FavouriteArticle> getFavouriteArticle() {
		return favouriteArticle;
	}

	public void setFavouriteArticle(List<FavouriteArticle> favouriteArticle) {
		this.favouriteArticle = favouriteArticle;
	}


	/*@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", blacklisted="
				+ blacklisted + ", role=" + role + ", language=" + language + ", favouriteArticle=" + favouriteArticle
				+ "]";
	}
*/
	
	

}
