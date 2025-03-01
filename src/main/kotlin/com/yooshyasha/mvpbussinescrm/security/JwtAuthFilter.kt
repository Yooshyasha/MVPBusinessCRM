package com.yooshyasha.mvpbussinescrm.security

import com.yooshyasha.mvpbussinescrm.services.UserService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter


@Component
class JwtAuthFilter(
    private val jwtUtil: JwtUtil,
    private val userService: UserService,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")
            ?: return doFilter(request, response, filterChain)

        if (!authHeader.startsWith("Bearer ")) {
            return doFilter(request, response, filterChain)
        }

        val authToken = authHeader.substring(7)
        val username = jwtUtil.extractUsernameFromToken(authToken)

        try {
            val user = userService.getUserByUsername(username)

            if (jwtUtil.verifyToken(authToken, user)) {
                val auth = UsernamePasswordAuthenticationToken(user, authToken)
                auth.details = WebAuthenticationDetailsSource().buildDetails(request)

                SecurityContextHolder.getContext().authentication = auth
            }
        } catch (e: Exception) {
            logger.error(e.message)

            return doFilter(request, response, filterChain)
        }

        return doFilter(request, response, filterChain)
    }
}