package com.saurabh.auth.apigateway.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.auth.apigateway.repository.UserRepository;
import com.saurabh.auth.apigateway.request.SignUpRequest;
import com.saurabh.auth.apigateway.response.ApiResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "User with email already exisits!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByUsername(request.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "Username is already taken!"), HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}
