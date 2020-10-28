package com.springrest.dto;

import com.springrest.model.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private Long uId;
    private String uNickname;
    private String uFirstName;
    private String uLastName;
    private int uAge;
    private String uEmail;
    private String uPassword;
    private String uConfirmPassword;
    private Set<Role> uSetRoles = new HashSet<>();

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuNickname() {
        return uNickname;
    }

    public void setuNickname(String uNickname) {
        this.uNickname = uNickname;
    }

    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuLastName() {
        return uLastName;
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public int getuAge() {
        return uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuConfirmPassword() {
        return uConfirmPassword;
    }

    public void setuConfirmPassword(String uConfirmPassword) {
        this.uConfirmPassword = uConfirmPassword;
    }

    public Set<Role> getuSetRoles() {
        return uSetRoles;
    }

    public void setuSetRoles(Set<Role> uSetRoles) {
        this.uSetRoles = uSetRoles;
    }
}
