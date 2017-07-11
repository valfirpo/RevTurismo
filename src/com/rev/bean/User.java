package com.rev.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "USERS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "myAwesomeCache")
public class User 
{
	@Id
	@Column(name = "U_ID")
	@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
	private int id;
	@Column(name = "U_USERNAME")
	private String username;
	@Column(name = "U_PASSWORD")
	private String password;
	@Column(name = "U_FIRSTNAME")
	private String firstname;
	@Column(name = "U_LASTNAME")
	private String lastname;
	@Column(name = "U_EMAIL")
	private String email;
	@Column(name = "U_CASH")
	private double cash;
	@Column(name = "UR_ID")
	private int urId;
	
	public User(){}
	
	public User(int id, String username, String password, String firstname, String lastname, String email, int cash,
			int urId) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cash = cash;
		this.urId = urId;
	}
	
	public User(String username, String password, String firstname, String lastname, String email, int cash, int urId) 
	{
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cash = cash;
		this.urId = urId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", cash=" + cash + ", urId=" + urId + "]";
	}
}
