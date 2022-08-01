package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.config.JwtUtils;
import sn.ias.Kspace.entities.JwtRequest;
import sn.ias.Kspace.entities.JwtResponse;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.helper.UserNotFoundException;
import sn.ias.Kspace.service.UserDetailsServiceImpl;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    private AuthenticationManager authenticationManager;
    private UserDetailsServiceImpl userDetailsService;
    private JwtUtils jwtUtils;

    public AuthenticateController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UserNotFoundException e)
        {
            e.printStackTrace();
            throw new Exception("Utilisateur non trouvé !");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("Utilisateur désactivé " +e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Identifiants invalides " + e.getMessage());
        }
    }

    // return the details of current user
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal) {
        return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
    }
}
