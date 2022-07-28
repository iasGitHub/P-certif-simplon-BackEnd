package sn.ias.Kspace.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sn.ias.Kspace.service.UserDetailsServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {


    private UserDetailsServiceImpl userDetailsService;

    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(UserDetailsServiceImpl userDetailsService, JwtUtils jwtUtils) {
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requesTokenHeader = request.getHeader("Authorization");
        System.out.println(requesTokenHeader);
        String username = null;
        String jwtToken = null;

        if(requesTokenHeader != null && requesTokenHeader.startsWith("Bearer "))
        {
            jwtToken = requesTokenHeader.substring(7);

            try {
                username = this.jwtUtils.extractUsername(jwtToken);
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                System.out.println("Le token a expiré !");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Erreur");
            }
        }else
        {
            System.out.println("Ce token n'est pas valide, vérifier qu'il contient le terme \"Bearer \" au début !");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.jwtUtils.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
            }
        } else {
            System.out.println("Ce token n'est pas valide ");
        }

        filterChain.doFilter(request, response);
    }
}
