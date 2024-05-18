package com.unicorn.rental.controller;

import com.unicorn.rental.service.car.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void carList() throws Exception {
        mockMvc.perform(get("/api/car")).andExpect(status().isOk());
    }

    @Test
    public void carFindByIdSuccessful() throws Exception {
        mockMvc.perform(get("/api/car/1")).andExpect(status().isOk());
    }

    @Test
    public void carFindByIdBadIdType() throws Exception {
        mockMvc.perform(get("/api/car/asdasd")).andExpect(status().isBadRequest());
    }

    @Test
    public void updateCar() throws Exception {
        String requestBody = "{ \"colorId\": 1, \"mileage\": 123 }";

        mockMvc.perform(put("/api/car/1")
                        .contentType("application/JSON").
                        content(requestBody))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Car successfully updated!"));
    }

    @Test
    public void updateCarNoBody() throws Exception {
        mockMvc.perform(put("/api/car/1")).andExpect(status().isBadRequest());
    }

    @Test
    public void updateCarBadMediaType() throws Exception {
        mockMvc.perform(put("/api/car/1")
                .contentType("text/html")
                .content("<div>ahoj</div>"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void createCar() throws Exception {
        String requestBody = "{ \"colorId\": 1, \"mileage\": 123, \"modelId\": 1, \"registrationNumber\": \"asdasd\" }";

        mockMvc.perform(post("/api/car")
                        .contentType("application/JSON")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Car created successfully!"));
    }

    @Test
    public void createCarNoBody() throws Exception {
        mockMvc.perform(post("/api/car")).andExpect(status().isBadRequest());
    }

    @Test
    public void createCarBadMediaType() throws Exception {
        mockMvc.perform(post("/api/car")
                        .contentType("text/html")
                        .content("<div>ahoj</div>"))
                .andExpect(status().isUnsupportedMediaType());
    }

    @Test
    public void deleteCarSuccessful() throws Exception {
        mockMvc.perform(delete("/api/car/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Car deleted successfully!"));
    }



}
