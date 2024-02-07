package com.TutorCentres.TutorSystem.core.utils;

import com.TutorCentres.TutorSystem.Tutor.repository.TutorRepository;
import com.TutorCentres.TutorSystem.core.entity.TutorUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtils{

    public static final String TOKEN_HEADER = "Authorization";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String TOKEN_UNDEFINED = "undefined";

    public static final String SECRET_KEY = "tutor_system";

    @Autowired
    private TutorRepository tutorRepository;

    public static String buildJwt(Authentication authentication){
        TutorUser user = (TutorUser) authentication.getPrincipal();
        Map<String, Object> map = new HashMap<>();
        map.put("email", user.getEmail());

        return Jwts.builder()
                .setSubject(user.getEmail())
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7)))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    };



}
