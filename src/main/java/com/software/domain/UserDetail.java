package com.software.domain;// default package

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user_detail"
        , catalog = "merchant"
)
public class UserDetail implements java.io.Serializable {
    private Integer id;
    // Fields
    private Department department;
    private String realname;
    private String sex;
    private String email;
    private Date birthday;
    private String telphone;
    private Timestamp logintime;
    private Timestamp logouttime;
    private String lastviewpage;

//    private User user;


    // Constructors

    /**
     * default constructor
     */
    public UserDetail() {
    }


    public UserDetail(String username, String password, String usertype, Boolean enable, Set<UserDetail> userDetails, Set<UserRole> userRoles, Department department, String realname, String sex, String email, Date birthday, String telphone, Timestamp logintime, Timestamp logouttime, String lastviewpage/*,User user*/) {
        this.department = department;
        this.realname = realname;
        this.sex = sex;
        this.email = email;
        this.birthday = birthday;
        this.telphone = telphone;
        this.logintime = logintime;
        this.logouttime = logouttime;
        this.lastviewpage = lastviewpage;
//        this.user = user;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @OneToOne(optional = false, cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "uid", referencedColumnName = "uid", unique = true)

//    @OneToOne(mappedBy="userDetail")
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    /**
     * full constructor
     */



    // Property accessors
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deptid")
    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Column(name = "realname")

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Column(name = "sex")

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "email")

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", length = 10)
    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "telphone", length = 15)

    public String getTelphone() {
        return this.telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @Column(name = "logintime", length = 19)

    public Timestamp getLogintime() {
        return this.logintime;
    }

    public void setLogintime(Timestamp logintime) {
        this.logintime = logintime;
    }

    @Column(name = "logouttime", length = 19)

    public Timestamp getLogouttime() {
        return this.logouttime;
    }

    public void setLogouttime(Timestamp logouttime) {
        this.logouttime = logouttime;
    }

    @Column(name = "lastviewpage")

    public String getLastviewpage() {
        return this.lastviewpage;
    }

    public void setLastviewpage(String lastviewpage) {
        this.lastviewpage = lastviewpage;
    }


}