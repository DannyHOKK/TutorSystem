package com.TutorCentres.TutorSystem.core.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class JwtResponseDTO {

    private String token;
    private Integer id;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponseDTO() {
    }

    public JwtResponseDTO(String token, Integer id,  String email, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.authorities = authorities;
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
