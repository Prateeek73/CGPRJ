package com.hms.userms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.userms.dto.AddUserRequest;
import com.hms.userms.dto.UpdatePasswordRequest;
import com.hms.userms.dto.UpdateUserRequest;
import com.hms.userms.dto.UserDetails;
import com.hms.userms.exception.UserNotFoundException;
import com.hms.userms.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new CentralExceptionHandler())
                .build();
    }

    // Test case for adding a new user with valid details
    @Test
    public void testAddNewUser_WithValidDetails() throws Exception {
        // Create an example valid AddUserRequest
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setFirstName("Prateek");
        addUserRequest.setLastName("Singh");
        addUserRequest.setEmail("singh.prateek2599@gmail.com");
        addUserRequest.setRole("USER");
        addUserRequest.setPassword("Prateek@2000");

        // Create an example UserDetails response after adding a new user
        UserDetails userDetails = new UserDetails();
        userDetails.setId("2");
        userDetails.setFirstName("Prateek");
        userDetails.setLastName("Singh");
        userDetails.setEmail("singh.prateek2599@gmail.com");
        userDetails.setRole("USER");
        userDetails.setReferenceId("patientRef");

        // Mock the userService.saveUser method to return the created user
        when(userService.saveUser(any(AddUserRequest.class))).thenReturn(userDetails);

        // Perform the POST request and validate the response
        mockMvc.perform(post("/api/users/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(addUserRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("2"))
                .andExpect(jsonPath("$.firstName").value("Prateek"))
                .andExpect(jsonPath("$.lastName").value("Singh"))
                .andExpect(jsonPath("$.email").value("singh.prateek2599@gmail.com"))
                .andExpect(jsonPath("$.role").value("USER"))
                .andExpect(jsonPath("$.referenceId").value("patientRef"));
    }

    // Test case for adding a new user with invalid data (BadRequest expected)
    @Test
    public void testAddNewUser_InvalidData() throws Exception {
        AddUserRequest request = new AddUserRequest();

        mockMvc.perform(post("/api/users/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest());
    }

    // Test case for updating a user with valid details
    @Test
    public void testUpdateUser_WithValidDetails() throws Exception {
        // Create an example valid UpdateUserRequest
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setEmail("singh.prateek2599@gmail.com");
        updateUserRequest.setFirstName("UpdatedPrateek");
        updateUserRequest.setLastName("UpdatedSingh");
        updateUserRequest.setPassword("Prateek@2000");

        // Create an example UserDetails response after updating the user
        UserDetails updatedUserDetails = new UserDetails();
        updatedUserDetails.setId("1");
        updatedUserDetails.setFirstName("UpdatedPrateek");
        updatedUserDetails.setLastName("UpdatedSingh");
        updatedUserDetails.setEmail("singh.prateek2599@gmail.com");
        updatedUserDetails.setRole("USER");
        updatedUserDetails.setReferenceId("patientRef");

        // Mock the userService.updateUser method to return the updated user
        when(userService.updateUser(any(UpdateUserRequest.class))).thenReturn(updatedUserDetails);

        // Perform the PUT request and validate the response
        mockMvc.perform(put("/api/users/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(updateUserRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstName").value("UpdatedPrateek"))
                .andExpect(jsonPath("$.lastName").value("UpdatedSingh"))
                .andExpect(jsonPath("$.email").value("singh.prateek2599@gmail.com"))
                .andExpect(jsonPath("$.role").value("USER"))
                .andExpect(jsonPath("$.referenceId").value("patientRef"));
    }

    // Test case for updating a user with invalid data (BadRequest expected)
    @Test
    public void testUpdateUser_InvalidData() throws Exception {
        UpdateUserRequest request = new UpdateUserRequest();

        mockMvc.perform(put("/api/users/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest());
    }

    // Test case for getting a user by email when user exists (OK expected)
    @Test
    public void testGetUserByEmail_Success() throws Exception {
        UserDetails userDetails = new UserDetails();
        userDetails.setId("1");
        userDetails.setFirstName("Prateek");
        userDetails.setLastName("Singh");
        userDetails.setEmail("singh.prateek2599@gmail.com");
        userDetails.setRole("USER");
        userDetails.setReferenceId("patientRef");

        when(userService.getUserByEmail(anyString())).thenReturn(userDetails);

        mockMvc.perform(get("/api/users/findByEmail/singh.prateek2599@gmail.com"))
                .andExpect(status().isOk());
    }

    // Test case for getting a user by email when user doesn't exist (NotFound expected)
    @Test
    public void testGetUserByEmail_UserNotFound() throws Exception {
        when(userService.getUserByEmail(anyString())).thenThrow(UserNotFoundException.class);

        mockMvc.perform(get("/api/users/findByEmail/nonexistent@example.com"))
                .andExpect(status().isNotFound());
    }

    // Test case for updating a user's password with valid details (OK expected)
    @Test
    public void testUpdatePassword_Success() throws Exception {
        UpdatePasswordRequest request = new UpdatePasswordRequest();
        request.setEmail("singh.prateek2599@gmail.com");
        request.setPassword("Pra733k@2000");

        UserDetails updatedUserDetails = new UserDetails();
        updatedUserDetails.setId("1");
        updatedUserDetails.setFirstName("Prateek");
        updatedUserDetails.setLastName("Singh");
        updatedUserDetails.setEmail("singh.prateek2599@gmail.com");
        updatedUserDetails.setRole("USER");
        updatedUserDetails.setReferenceId("patientRef");

        when(userService.updatePassword(any(UpdatePasswordRequest.class))).thenReturn(updatedUserDetails);

        mockMvc.perform(put("/api/users/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isOk());
    }

    // Test case for updating a user's password when user doesn't exist (NotFound expected)
    @Test
    public void testUpdatePassword_UserNotFound() throws Exception {
        UpdatePasswordRequest request = new UpdatePasswordRequest();
        request.setEmail("singh.prateek2599@gmail.com");

        when(userService.updatePassword(any(UpdatePasswordRequest.class))).thenThrow(UserNotFoundException.class);

        mockMvc.perform(put("/api/users/updatePassword")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isNotFound());
    }

    // Test case for adding a reference ID to a user with valid details (OK expected)
    @Test
    public void testAddReference_Success() throws Exception {
        UserDetails updatedUserDetails = new UserDetails();
        updatedUserDetails.setId("1");
        updatedUserDetails.setFirstName("Prateek");
        updatedUserDetails.setLastName("Singh");
        updatedUserDetails.setEmail("singh.prateek2599@gmail.com");
        updatedUserDetails.setRole("USER");
        updatedUserDetails.setReferenceId("patientRef");

        when(userService.addReferenceId(eq("singh.prateek2599@gmail.com"), eq("patientRef"))).thenReturn(updatedUserDetails);

        mockMvc.perform(get("/api/users/addReference/singh.prateek2599@gmail.com/patientRef"))
                .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}