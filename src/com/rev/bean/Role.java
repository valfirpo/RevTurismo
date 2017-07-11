package com.rev.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "RT_USER_ROLES")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "myAwesomeCache")
public class Role 
{
	@Id
	@Column(name = "UR_ID")
	@SequenceGenerator(name = "ROLES_UR_ID_SEQ", sequenceName = "ROLES_UR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_UR_ID_SEQ")
	private int urId;
	
	@Column(name = "UR_ROLE")
	private String role;
	
	@OneToMany(mappedBy = "urId")
	private List<User> usersList;
	
	public Role(){}

	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}

	@Override
	public String toString() {
		return "Role [urId=" + urId + ", role=" + role + ", usersList=" + usersList + "]";
	}
}
