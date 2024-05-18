package com.unicorn.rental.controller;

import com.unicorn.rental.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void userList() throws Exception {
        mockMvc.perform(get("/api/user")).andExpect(status().isOk());
    }

    @Test
    public void userCreateSuccessful() throws Exception {
        String validRequestBody = "{\n  \"fullName\": \"John Doe\",\n  \"address\": {\n    \"street\": \"Madeup\",\n    \"building\": 123,\n    \"cityId\": 1\n  }\n}";
        mockMvc.perform(post("/api/user").contentType("application/json").content(validRequestBody)).andExpect(status().isOk());
    }

    @Test
    public void userCreateEmptyBody() throws Exception {
        mockMvc.perform(post("/api/user").contentType("application/json")).andExpect(status().isBadRequest());
    }

    @Test
    public void userCreateUnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/user").contentType("text/html")).andExpect(status().isUnsupportedMediaType());
    }



}
