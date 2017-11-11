package com.software.domain;// default package

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_role"
    ,catalog="merchant"
)

public class Role  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String rolename;
     private String description;
     private Timestamp createtime;
     private Set<UserRole> userRoles = new HashSet<UserRole>(0);
     private Set<RolePrivilege> rolePrivileges = new HashSet<RolePrivilege>(0);


    // Constructors

    /** default constructor */
    public Role() {
    }

	/** minimal constructor */
    public Role(String rolename) {
        this.rolename = rolename;
    }
    
    /** full constructor */
    public Role(String rolename, String description, Timestamp createtime, Set<UserRole> userRoles, Set<RolePrivilege> rolePrivileges) {
        this.rolename = rolename;
        this.description = description;
        this.createtime = createtime;
        this.userRoles = userRoles;
        this.rolePrivileges = rolePrivileges;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="rolename", nullable=false)

    public String getRolename() {
        return this.rolename;
    }
    
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    
    @Column(name="description")

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="createtime", length=19)

    public Timestamp getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="role")

    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }
    
    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="role")

    public Set<RolePrivilege> getRolePrivileges() {
        return this.rolePrivileges;
    }
    
    public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
        this.rolePrivileges = rolePrivileges;
    }
   








}