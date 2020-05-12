package com.example.oauth2login;

import com.example.oauth2login.controller.UserController;
import com.example.oauth2login.exception.IllegalArgumentException;
import com.example.oauth2login.exception.handler.IllegalArgumentHandler;
import com.example.oauth2login.model.User;
import com.example.oauth2login.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private final static int ID = 1;
    private final static String USERNAME = "username";
    private final static String PASSWORD = "password";
    private final static boolean ACTIVE = true;
    private final static String ROLES = "ROLE_USER,ROLE_ADMIN";

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    private void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(IllegalArgumentHandler.class)
                .build();
    }

    @Test
    void getUserByIdWhenExistsThenReturnsUser() throws Exception {
        User user = new User(ID, USERNAME, PASSWORD, ACTIVE, ROLES);

        given(userService.getById(ID)).willReturn(user);
        MockHttpServletResponse response = mockMvc.perform(
                get("/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(TestHelper.convertToJson(user));
    }

    @Test
    void getUserByIdWhenIsNullThenReturns404NotFound() throws Exception {
        given(userService.getById(anyInt())).willThrow(IllegalArgumentException.class);

        MockHttpServletResponse response = mockMvc.perform(
                get("/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
    }

    @Test
    void getUserByIdWhenDefaultIdThenReturnDefault() throws Exception {
        User user = new User(ID, USERNAME, PASSWORD, ACTIVE, ROLES);

        given(userService.getById(anyInt())).willReturn(user);

        MockHttpServletResponse response = mockMvc.perform(
                get("/user")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getContentAsString()).isEqualTo(TestHelper.convertToJson(user));
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
