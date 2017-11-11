package com.software.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RolePrivilege entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_role_privilege", catalog = "merchant")

public class RolePrivilege implements java.io.Serializable {

	// Fields

	private Integer id;
	private Privilege privilege;
	private Role role;

	// Constructors

	/** default constructor */
	public RolePrivilege() {
	}

	/** full constructor */
	public RolePrivilege(Privilege privilege, Role role) {
		this.privilege = privilege;
		this.role = role;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", nullable = false)

	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rid", nullable = false)

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}