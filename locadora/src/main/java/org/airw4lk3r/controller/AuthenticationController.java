package org.airw4lk3r.controller;

import java.net.URI;
import java.util.Collections;

import org.airw4lk3r.payload.SignUpRequest;
import org.airw4lk3r.model.Role;
import org.airw4lk3r.model.RoleName;
import org.airw4lk3r.model.User;
import org.airw4lk3r.payload.CredentialsRequest;
import org.airw4lk3r.payload.JwtAuthenticationResponse;
import org.airw4lk3r.repository.RoleRepository;
import org.airw4lk3r.repository.UserRepository;
import org.airw4lk3r.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
		
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody CredentialsRequest credentials){
		
		Authentication authentication = authenticationManager.authenticate(				
				new UsernamePasswordAuthenticationToken(
						credentials.getUsernameOrEmail(),
						credentials.getPassword())
				
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
		
	}
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("Username already in use!",HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>("Email Address already in use!",HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getPassword(), signUpRequest.getEmail());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //.orElseThrow(() -> new Exception("User Role not set."));
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElse(null);                

        user.setRoles(Collections.singleton(userRole));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body("User registered successfully");
    }
	
}
