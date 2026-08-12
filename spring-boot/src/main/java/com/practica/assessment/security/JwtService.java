package com.practica.assessment.security;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;

import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final JwtProperties jwtProperties;
    private final JwtEncoder jwtEncoder;



    public JwtService(JwtProperties jwtProperties) {

        this.jwtProperties = jwtProperties;

        SecretKey secretKey = new SecretKeySpec(
                jwtProperties.secret().getBytes(StandardCharsets.UTF_8),
                "HmacSHA256"
        );

        OctetSequenceKey jwk = new OctetSequenceKey.Builder(secretKey)
                .algorithm(com.nimbusds.jose.JWSAlgorithm.HS256)
                .build();

        this.jwtEncoder = new NimbusJwtEncoder(
                new ImmutableJWKSet<>(new JWKSet(jwk))
        );
    }

    public String generateToken(String username) {

        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(username)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(jwtProperties.expiration()))
                .claim("role", "USER")
                .build();

        return jwtEncoder
                .encode(
                        JwtEncoderParameters.from(
                                JwsHeader.with(MacAlgorithm.HS256).build(),
                                claims
                        )
                )
                .getTokenValue();
    }
}