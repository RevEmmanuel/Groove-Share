package org.grooveshare.playlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.grooveshare.playlist.data.dto.request.CreateUserRequest;
import org.grooveshare.playlist.data.dto.request.DeleteUserRequest;
import org.grooveshare.playlist.data.dto.request.LoginRequest;
import org.grooveshare.playlist.data.dto.request.UpdateUserDetailsRequest;
import org.grooveshare.playlist.data.dto.response.CreateUserResponse;
import org.grooveshare.playlist.data.dto.response.FindUserResponse;
import org.grooveshare.playlist.data.dto.response.LoginResponse;
import org.grooveshare.playlist.data.models.UserEntity;
import org.grooveshare.playlist.exceptions.PlaylistException;
import org.grooveshare.playlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Signup")
    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> signup(@Valid @RequestBody CreateUserRequest userRequest) {
        return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.OK);
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

    @Operation(summary = "Delete user account")
    @DeleteMapping("/delete-user")
    public ResponseEntity<String> deleteAccount(@Valid @RequestBody DeleteUserRequest deleteUserRequest) {
        return new ResponseEntity<>(userService.deleteUser(deleteUserRequest), HttpStatus.OK);
    }

    @Operation(summary = "Find all users")
    @GetMapping("/user/all")
    public ResponseEntity<List<FindUserResponse>> findAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Delete user's profile picture")
    @DeleteMapping("/delete-image")
    public ResponseEntity<String> deleteProfilePicture() {
        return new ResponseEntity<>(userService.deleteProfileImage(), HttpStatus.OK);
    }

    @Operation(summary = "Update A Particular User's profile picture",
            description = "Returns an ApiResponse Response entity containing the operation details")
    @PostMapping(value = "/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadProfilePicture(@RequestParam(value = "file") MultipartFile file) {
        try {
            String response = userService.uploadProfileImage(file);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (PlaylistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping
    @Operation(summary = "Current User", description = "Get the current user")
    public ResponseEntity<UserEntity> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PatchMapping("/update")
    @Operation(summary = "Update user details", description = "Update the user details")
    public ResponseEntity<FindUserResponse> updateUser(@Valid @RequestBody UpdateUserDetailsRequest updateRequest) {
        return new ResponseEntity<>(userService.updateUserDetails(updateRequest), HttpStatus.OK);
    }
}

