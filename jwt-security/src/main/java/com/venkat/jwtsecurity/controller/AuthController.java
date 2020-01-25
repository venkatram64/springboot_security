package com.venkat.jwtsecurity.controller;


import com.venkat.jwtsecurity.model.AuthUserRequest;
import com.venkat.jwtsecurity.model.AuthUserResponse;
import com.venkat.jwtsecurity.service.JwtService;
import com.venkat.jwtsecurity.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myAppUserDetails;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value="/authenticate",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthUserRequest authUserRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authUserRequest.getUsername(), authUserRequest.getPassword()));
        }catch (BadCredentialsException ex){
            throw new Exception("Incorrect username or password");
        }
        final UserDetails userDetails = myAppUserDetails.loadUserByUsername(authUserRequest.getUsername());
        final String jwt = jwtService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthUserResponse(jwt));
    }
}
