package com.ken.mypet.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
// import com.demo.spring_security_demo.helpers.JwtUtils;
import com.ken.mypet.helpers.JwtHelper;
import com.ken.mypet.services.Impl.PersonServiceImpl;

import java.io.IOException;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component

public class JwtFilter extends OncePerRequestFilter {
    private final JwtHelper jwtHelper;
    private final PersonServiceImpl personService;

    @Autowired
    public JwtFilter(JwtHelper jwtHelper, PersonServiceImpl personService) {
        this.jwtHelper = jwtHelper;
        this.personService = personService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader(AUTHORIZATION);
        final String userEmail;
        final String jwtToken;
        System.out.println("hello");
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            System.out.println("in condition111");
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("this is authHeader" + personService);
        jwtToken = authHeader.substring(7);
        userEmail = jwtHelper.extractName(jwtToken);
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = (UserDetails) personService.findByEmail(userEmail);
            if(userDetails != null){
                if(jwtHelper.validateToken(jwtToken, userDetails)){
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

        }
        filterChain.doFilter(request, response);
    }
}
