package com.rev.bean;

public class Role 
{
	private int urId;
	private String role;
	
	public Role(){}
	
	public Role(int urId, String role) {
		super();
		this.urId = urId;
		this.role = role;
	}

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

	@Override
	public String toString() {
		return "Role [urId=" + urId + ", role=" + role + "]";
	}
}
