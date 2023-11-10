package com.example.team_project._core.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.team_project.user.User;

import java.time.Instant;

public class JwtTokenUtils {

    public static String create(User user){
        String jwt = JWT.create()
                .withSubject("metacoding-key")
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withExpiresAt(Instant.now().plusMillis(1000*60*60*24*36500L))
                .sign(Algorithm.HMAC512("meta"));
        return "Bearer " + jwt;
    }

    public static DecodedJWT verify(String jwt) throws SignatureVerificationException, TokenExpiredException {
        jwt = jwt.replace("Bearer ", "");

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512("meta"))
                .build().verify(jwt);
        return decodedJWT;
    }
}