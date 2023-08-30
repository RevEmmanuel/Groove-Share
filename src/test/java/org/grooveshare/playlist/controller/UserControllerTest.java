package org.grooveshare.playlist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.grooveshare.playlist.data.dto.request.CreateUserRequest;
import org.grooveshare.playlist.data.dto.request.LoginRequest;
import org.grooveshare.playlist.data.dto.response.CreateUserResponse;
import org.grooveshare.playlist.data.dto.response.LoginResponse;
import org.grooveshare.playlist.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void signup() throws Exception {
        var requestDto = CreateUserRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@email.com")
                .password("password")
                .username("Johnny001")
                .build();

        given(userService.createUser(requestDto)).willReturn(CreateUserResponse.builder().build());
        mockMvc.perform(
                        post("/api/v1/auth/signup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto))
                )
                .andExpect(status().isOk());
    }

    @Test
    void signupFailsTest() throws Exception {
        var requestDto = CreateUserRequest.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john")
                .password("password")
                .username("Johnny001")
                .build();

        given(userService.createUser(requestDto)).willReturn(CreateUserResponse.builder().build());

        mockMvc.perform(
                        post("/api/v1/auth/signup")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(requestDto))
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void login() throws Exception {
        var loginRequest = LoginRequest.builder()
                .email("john@email.com")
                .password("password")
                .build();

        given(userService.login(loginRequest)).willReturn(LoginResponse.builder().accessToken("eJyueqwyi").refreshToken("vhshvhbskbhk").build());

        mockMvc.perform(
                        post("/api/v1/auth/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(loginRequest))
                )
                .andExpect(status().isOk());
    }
}