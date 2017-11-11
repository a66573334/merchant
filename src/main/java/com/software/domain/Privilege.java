package com.software.domain;// default package

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_privilege"
    ,catalog="merchant"
)

public class Privilege  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String url;
     private String privilegeName;
     private String description;
     private Integer pid;
     private Set<RolePrivilege> rolePrivileges = new HashSet<RolePrivilege>(0);


    // Constructors

    /** default constructor */
    public Privilege() {
    }

    
    /** full constructor */
    public Privilege(String url, String privilegeName, String description, Integer pid, Set<RolePrivilege> rolePrivileges) {
        this.url = url;
        this.privilegeName = privilegeName;
        this.description = description;
        this.pid = pid;
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
    
    @Column(name="url")

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="privilegeName")

    public String getPrivilegeName() {
        return this.privilegeName;
    }
    
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
    
    @Column(name="description")

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="pid")

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="privilege")

    public Set<RolePrivilege> getRolePrivileges() {
        return this.rolePrivileges;
    }
    
    public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
        this.rolePrivileges = rolePrivileges;
    }
   








}