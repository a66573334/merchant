package com.software.domain;// default package

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user"
        , catalog = "merchant"
)
public class User implements java.io.Serializable {


    // Fields    

    private Integer id;
    private String username;
    private String password;
    private String usertype;
    private Boolean enable;

    private UserDetail userDetail;
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);


    // Constructors

    /**
     * default constructor
     */
    public User() {
    }

    /**
     * minimal constructor
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * full constructor
     */
    public User(String username, String password, String usertype, Boolean enable, UserDetail userDetail, Set<UserRole> userRoles) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.enable = enable;
        this.userDetail = userDetail;
        this.userRoles = userRoles;
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

    @Column(name = "username", nullable = false)

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "usertype", length = 10)

    public String getUsertype() {
        return this.usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Column(name = "enable", precision = 1, scale = 0)

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")

    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

//    @OneToOne(optional = true, cascade = CascadeType.ALL, mappedBy = "user")
//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
    @OneToOne
    @JoinColumn(name="dtId")
    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}