package com.yooshyasha.mvpbussinescrm.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey


@Component
class JwtUtil {
    private final val SECRET: SecretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode("mySecret"))
    private final val TOKENLIFETIME: Long = 60 * 60 * 1000

    fun verifyToken(token: String, userDetails: UserDetails): Boolean {
        val claims = extractAllClaimsFromToken(token)

        return (userDetails.username == extractUsernameFromToken(token) && !claims.expiration.before(Date()))
    }

    fun extractUsernameFromToken(token: String): String {
        return extractAllClaimsFromToken(token).subject
    }

    fun extractAllClaimsFromToken(token: String): Claims {
        return Jwts.parser()
            .verifyWith(SECRET)
            .build()
            .parseSignedClaims(token)
            .payload
    }

    fun generateToken(userDetails: UserDetails): String {
        return Jwts.builder()
            .signWith(SECRET)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + TOKENLIFETIME))
            .subject(userDetails.username)
            .compact()
    }
}