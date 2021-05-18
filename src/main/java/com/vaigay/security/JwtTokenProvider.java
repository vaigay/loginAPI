package com.vaigay.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class JwtTokenProvider {
	
	private final String JWT_KEY = "vaigay123";
	
	private final long JWT_EXPRIRATION = 1000*60*60;
	
	public String generateToken(UserDetailImp UserDetail) {
		Date now = new Date(System.currentTimeMillis());
		Date expriDate = new Date(now.getTime() + JWT_EXPRIRATION);
		
		return Jwts.builder()
				.setSubject(Long.toString(UserDetail.getUserId()))
				.setIssuedAt(now)
				.setExpiration(expriDate)
				.signWith(SignatureAlgorithm.HS256, JWT_KEY)
				.compact();
	}
	
	public Long getUserIdFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(JWT_KEY)
				.parseClaimsJws(token)
				.getBody();

		return Long.parseLong(claims.getSubject());
	}
	
	public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("Invalid JWT token");
            return false;
        } catch (ExpiredJwtException ex) {
        	 System.out.println("Expired JWT token");
        	 return false;
        } catch (UnsupportedJwtException ex) {
        	 System.out.println("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
        	 System.out.println("JWT claims string is empty.");
        }
        System.out.println("123");
        return false;
    }
}
