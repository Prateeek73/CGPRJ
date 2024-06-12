package com.hms.hospitalms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.hospitalms.dto.AddHospitalRequest;
import com.hms.hospitalms.entities.Hospital;
import com.hms.hospitalms.exception.HospitalNotFoundException;
import com.hms.hospitalms.service.IHospitalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HospitalControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IHospitalService hospitalService;

    @InjectMocks
    private HospitalController hospitalController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(hospitalController)
                .setControllerAdvice(new CentralExceptionHandler())
                .build();
    }

    // Test case for adding a new hospital with invalid data (BadRequest expected)
    @Test
    public void testAddHospital_InvalidData() throws Exception {
        AddHospitalRequest request = new AddHospitalRequest();

        mockMvc.perform(post("/api/hospitals/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest());
    }

    // Test case for updating a hospital with invalid data (BadRequest expected)
    @Test
    public void testUpdateHospital_InvalidData() throws Exception {
        AddHospitalRequest request = new AddHospitalRequest();

        mockMvc.perform(put("/api/hospitals/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(request)))
                .andExpect(status().isBadRequest());
    }

    // Test case for getting a hospital by ID when hospital exists (OK expected)
    @Test
    public void testGetHospitalById_Success() throws Exception {
        Hospital hospital = new Hospital();
        hospital.setId("1");
        hospital.setName("Hospital Name");
        hospital.setHospitalType(Hospital.HospitalType.PRIVATE);
        hospital.setContactNo(1234567890L);
        hospital.setAddress(new Hospital.Address("City", "State", 12345L));

        when(hospitalService.findHospitalById(eq("1"))).thenReturn(hospital);

        mockMvc.perform(get("/api/hospitals/findById/1"))
                .andExpect(status().isOk());
    }

    // Test case for getting a hospital by ID when hospital doesn't exist (NotFound expected)
    @Test
    public void testGetHospitalById_HospitalNotFound() throws Exception {
        when(hospitalService.findHospitalById(eq("1"))).thenThrow(HospitalNotFoundException.class);

        mockMvc.perform(get("/api/hospitals/findById/1"))
                .andExpect(status().isNotFound());
    }

    // Test case for checking if a hospital is verified when it's verified (OK expected)
    @Test
    public void testIsHospitalVerified_Verified() throws Exception {
        Hospital hospital = new Hospital();
        hospital.setId("1");
        hospital.setVerified(true);

        when(hospitalService.isHospitalVerified(eq("1"))).thenReturn(true);

        mockMvc.perform(get("/api/hospitals/isVerified/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    // Test case for checking if a hospital is verified when it's not verified (OK expected)
    @Test
    public void testIsHospitalVerified_NotVerified() throws Exception {
        Hospital hospital = new Hospital();
        hospital.setId("1");
        hospital.setVerified(false);

        when(hospitalService.isHospitalVerified(eq("1"))).thenReturn(false);

        mockMvc.perform(get("/api/hospitals/isVerified/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    // Test case for checking if a hospital is verified when hospital doesn't exist (NotFound expected)
    @Test
    public void testIsHospitalVerified_HospitalNotFound() throws Exception {
        when(hospitalService.isHospitalVerified(eq("1"))).thenThrow(HospitalNotFoundException.class);

        mockMvc.perform(get("/api/hospitals/isVerified/1"))
                .andExpect(status().isNotFound());
    }

    // Test case for verifying a hospital when it doesn't exist (NotFound expected)
    @Test
    public void testVerifyHospital_HospitalNotFound() throws Exception {
        when(hospitalService.verifyHospital(eq("1"))).thenThrow(HospitalNotFoundException.class);

        mockMvc.perform(put("/api/hospitals/verify/1"))
                .andExpect(status().isNotFound());
    }

    // Test case for getting nearby hospitals with a valid pincode (OK expected)
    @Test
    public void testGetNearbyHospitals_Success() throws Exception {
        Long pincode = 226025L;

        Hospital hospital1 = new Hospital();
        hospital1.setId("1");
        hospital1.setName("Apollo Hospital");
        hospital1.setHospitalType(Hospital.HospitalType.PRIVATE);
        hospital1.setContactNo(7270043813L);
        hospital1.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226022L));

        Hospital hospital2 = new Hospital();
        hospital2.setId("2");
        hospital2.setName("Medanta Hospital");
        hospital2.setHospitalType(Hospital.HospitalType.GOVT);
        hospital2.setContactNo(7270043813L);
        hospital2.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226024L));

        List<Hospital> nearbyHospitals = List.of(hospital1, hospital2);

        when(hospitalService.getNearbyHospitals(eq(pincode))).thenReturn(nearbyHospitals);

        mockMvc.perform(get("/api/hospitals/nearby/226025"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}