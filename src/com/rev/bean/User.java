package com.rev.bean;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_USERS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
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
	
	@Column(name="UR_ID")
	private int role; 
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@Column(name = "UR_ID")
//	private Role role;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "RT_CAR_OWNERSHIP", joinColumns = @JoinColumn(name="U_ID"), inverseJoinColumns= @JoinColumn(name="C_ID"))
	private List<Car> cars;
	
	
	
	public String userRole;
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public User(){}
	
	public User(String username, String password){
		this.username=username;
		this.password=password;
	}

	public User(String username, String password, String firstname, String lastname, String email, double cash,
			int role, List<Car> cars) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cash = cash;
		this.role = role;
		this.cars = cars;
	}

	public User(int id, String username, String password, String firstname, String lastname, String email, double cash,
			int role, List<Car> cars) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.cash = cash;
		this.role = role;
		this.cars = cars;
	}

	public User(String username, String password,  double cash, int role) {
		this.username = username;
		this.password = password;
		this.cash = cash;
		this.role = role;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", cash=" + cash + ", role=" + role + ", cars=" + cars
				+ "]";
	}

	
}
