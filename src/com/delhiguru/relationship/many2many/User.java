package com.delhiguru.relationship.many2many;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private Integer id;
	private String username;
	private String password;
	
	private Role[] rolesArray;
	private List<Role> roles;
	
	

	/**
	 * @return the rolesArray
	 */
	public Role[] getRolesArray() {
		return rolesArray;
	}

	/**
	 * @param rolesArray the rolesArray to set
	 */
	public void setRolesArray(Role[] rolesArray) {
		this.rolesArray = rolesArray;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private String description;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
