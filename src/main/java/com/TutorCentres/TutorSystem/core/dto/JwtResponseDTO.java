package com.TutorCentres.TutorSystem.core.dto;

public class JwtResponseDTO {

    private String token;
    private Integer id;
    private String email;

    public JwtResponseDTO() {
    }

    public JwtResponseDTO(String token, Integer id,  String email) {
        this.token = token;
        this.id = id;
        this.email = email;
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
