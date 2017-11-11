package com.software.domain;// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_department"
    ,catalog="merchant"
)

public class Department  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String deptname;
     private String deptdesc;
     private Integer pid;
     private Integer deptlevel;
     private Set<UserDetail> userDetails = new HashSet<UserDetail>(0);


    // Constructors

    /** default constructor */
    public Department() {
    }

	/** minimal constructor */
    public Department(String deptname) {
        this.deptname = deptname;
    }
    
    /** full constructor */
    public Department(String deptname, String deptdesc, Integer pid, Integer deptlevel, Set<UserDetail> userDetails) {
        this.deptname = deptname;
        this.deptdesc = deptdesc;
        this.pid = pid;
        this.deptlevel = deptlevel;
        this.userDetails = userDetails;
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
    
    @Column(name="deptname", nullable=false)

    public String getDeptname() {
        return this.deptname;
    }
    
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    
    @Column(name="deptdesc")

    public String getDeptdesc() {
        return this.deptdesc;
    }
    
    public void setDeptdesc(String deptdesc) {
        this.deptdesc = deptdesc;
    }
    
    @Column(name="pid")

    public Integer getPid() {
        return this.pid;
    }
    
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    
    @Column(name="deptlevel")

    public Integer getDeptlevel() {
        return this.deptlevel;
    }
    
    public void setDeptlevel(Integer deptlevel) {
        this.deptlevel = deptlevel;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="department")

    public Set<UserDetail> getUserDetails() {
        return this.userDetails;
    }
    
    public void setUserDetails(Set<UserDetail> userDetails) {
        this.userDetails = userDetails;
    }
   








}