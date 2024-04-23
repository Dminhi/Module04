package com.example.securiry.securiry.jwt;

import com.example.securiry.securiry.principle.UserDetailsServiceCustom;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Slf4j

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    public  JwtProvider provider;
    @Autowired
    public UserDetailsServiceCustom userDetailsServiceCustom;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = getTokenFromRequest(request);
            if(token!=null && provider.validateToken(token)){
                String username = provider.getUserNameFromToken(token);
                if(username != null){
                    UserDetails userDetails = userDetailsServiceCustom.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        } catch (Exception e){
        log.error("UnThentication",e.getMessage());
        }
        filterChain.doFilter(request,response);
    }
    public String getTokenFromRequest(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if(header!=null&&header.startsWith("Bearer ")){
            return header.substring(7);
        }
        return null;
    }
}
