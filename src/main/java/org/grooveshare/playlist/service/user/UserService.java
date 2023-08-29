package org.grooveshare.playlist.service.user;

import org.springframework.web.multipart.MultipartFile;
import org.grooveshare.playlist.data.dto.request.CreateUserRequest;
import org.grooveshare.playlist.data.dto.request.DeleteUserRequest;
import org.grooveshare.playlist.data.dto.request.LoginRequest;
import org.grooveshare.playlist.data.dto.request.UpdateUserDetailsRequest;
import org.grooveshare.playlist.data.dto.response.CreateUserResponse;
import org.grooveshare.playlist.data.dto.response.FindUserResponse;
import org.grooveshare.playlist.data.dto.response.LoginResponse;
import org.grooveshare.playlist.data.models.UserEntity;
import java.util.List;

public interface UserService {

    CreateUserResponse createUser(CreateUserRequest userRequest);

    LoginResponse login(LoginRequest loginRequest);

    UserEntity getCurrentUser();

    FindUserResponse findUserByUserName(String userName);

    String deleteUser(DeleteUserRequest deleteRequest);

    String uploadProfileImage(MultipartFile profileImage);

    String deleteProfileImage();

    List<FindUserResponse> findAll();

    FindUserResponse updateUserDetails(UpdateUserDetailsRequest updateUserDetailsRequest);

}
