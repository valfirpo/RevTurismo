package com.rev.bean;

<<<<<<< HEAD
<<<<<<< HEAD
public class User {
  private String username;
  private String password;
  private String firstname;
  private String lastname;
  private String email;
  private String address;
  private int phone;
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
  public String getAddress() {
  return address;
  }
  public void setAddress(String address) {
  this.address = address;
  }
  public int getPhone() {
  return phone;
  }
  public void setPhone(int phone) {
  this.phone = phone;
  }
=======
=======
>>>>>>> master
public class User 
{
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private int cash;
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

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
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
<<<<<<< HEAD
>>>>>>> refs/heads/master
=======
>>>>>>> master
}
