package com.unicorn.rental.controller;

import com.unicorn.rental.service.carRental.CarRentalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CarRentalController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class CarRentalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CarRentalService service;

    @Test
    public void carRentalCreateSuccessful() throws Exception {
        String validRequestBody = "{\n  \"carId\": 1,\n  \"userId\": 1,\n  \"rentedTo\": \"2024-02-18T18:37:41.457Z\",\n  \"rentedFrom\": \"2024-02-18T18:37:41.457Z\"\n}";
        mockMvc.perform(post("/api/carRental").contentType("application/json").content(validRequestBody)).andExpect(status().isOk());
    }

    @Test
    public void carRentalCreateEmptyBody() throws Exception {
        mockMvc.perform(post("/api/carRental").contentType("application/json")).andExpect(status().isBadRequest());
    }

    @Test
    public void carRentalUnsupportedMediaType() throws Exception {
        mockMvc.perform(post("/api/carRental").contentType("text/html")).andExpect(status().isUnsupportedMediaType());
    }

}
