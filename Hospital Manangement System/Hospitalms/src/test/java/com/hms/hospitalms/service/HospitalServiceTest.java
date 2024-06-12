package com.hms.hospitalms.service;

import com.hms.hospitalms.dto.AddHospitalRequest;
import com.hms.hospitalms.entities.Hospital;
import com.hms.hospitalms.entities.Hospital.HospitalType;
import com.hms.hospitalms.exception.HospitalNotFoundException;
import com.hms.hospitalms.repository.IHospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class HospitalServiceTest {

    @Mock
    private IHospitalRepository hospitalRepository;

    @InjectMocks
    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test case for adding a new hospital
    @Test
    void testAddHospital() {
        // Arrange
        AddHospitalRequest request = createAddHospitalRequest();
        Hospital expectedHospital = createHospital();

        // Mock
        when(hospitalRepository.save(any(Hospital.class)))
            .thenReturn(expectedHospital);

        // Act and Assert
        assertEquals(expectedHospital, hospitalService.addHospital(request));

        // Verify that the hospitalRepository.save method was called once
        verify(hospitalRepository, times(1)).save(any(Hospital.class));
    }

    // Test case for updating an existing hospital
    @Test
    void testUpdateHospital() {
        // Arrange
        String hospitalId = "1";
        AddHospitalRequest request = createAddHospitalRequest();
        Hospital existingHospital = createHospital();

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.of(existingHospital));
        when(hospitalRepository.save(any(Hospital.class))).thenReturn(existingHospital);

        // Act
        Hospital updatedHospital = hospitalService.updateHospital(hospitalId, request);

        // Assert
        assertEquals(request.getName(), updatedHospital.getName());
        assertEquals(request.getHospitalType(), updatedHospital.getHospitalType().toString());

        // Verify that findById and save methods were called
        verify(hospitalRepository, times(1)).findById(hospitalId);
        verify(hospitalRepository, times(1)).save(any(Hospital.class));
    }

    // Test case for updating a hospital when it's not found
    @Test
    void testUpdateHospitalHospitalNotFound() {
        // Arrange
        String hospitalId = "1";
        AddHospitalRequest request = createAddHospitalRequest();

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(HospitalNotFoundException.class, () -> hospitalService.updateHospital(hospitalId, request));

        // Verify that findById was called once and save was never called
        verify(hospitalRepository, times(1)).findById(hospitalId);
        verify(hospitalRepository, never()).save(any(Hospital.class));
    }

    // Test case for finding a hospital by ID
    @Test
    void testFindHospitalById() {
        // Arrange
        String hospitalId = "1";
        Hospital expectedHospital = createHospital();

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.of(expectedHospital));

        // Act
        Hospital result = hospitalService.findHospitalById(hospitalId);

        // Assert
        assertEquals(expectedHospital, result);

        // Verify that findById was called once
        verify(hospitalRepository, times(1)).findById(hospitalId);
    }

    // Test case for finding a hospital when it's not found
    @Test
    void testFindHospitalByIdHospitalNotFound() {
        // Arrange
        String hospitalId = "1";

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(HospitalNotFoundException.class, () -> hospitalService.findHospitalById(hospitalId));

        // Verify
        verify(hospitalRepository, times(1)).findById(hospitalId);
    }

    // Test case for checking if a hospital is verified
    @Test
    void testIsHospitalVerified() {
        // Arrange
        String hospitalId = "1";
        Hospital hospital = createHospital();
        hospital.setVerified(true);

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.of(hospital));

        // Act
        Boolean result = hospitalService.isHospitalVerified(hospitalId);

        // Assert
        assertTrue(result);

        // Verify
        verify(hospitalRepository, times(1)).findById(hospitalId);
    }

    // Test case for checking if a hospital is not verified
    @Test
    void testIsHospitalNotVerified() {
        // Arrange
        String hospitalId = "1";
        Hospital hospital = createHospital();
        hospital.setVerified(false);

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.of(hospital));

        // Act
        Boolean result = hospitalService.isHospitalVerified(hospitalId);

        // Assert
        assertFalse(result);

        // Verify
        verify(hospitalRepository, times(1)).findById(hospitalId);
    }

    // Test case for checking if a hospital is verified when it's not found
    @Test
    void testIsHospitalVerifiedHospitalNotFound() {
        // Arrange
        String hospitalId = "1";

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(HospitalNotFoundException.class, () -> hospitalService.isHospitalVerified(hospitalId));

        // Verify
        verify(hospitalRepository, times(1)).findById(hospitalId);
    }

    // Test case for verifying a hospital
    @Test
    void testVerifyHospital() {
        // Arrange
        String hospitalId = "1";
        Hospital hospital = createHospital();

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.of(hospital));
        when(hospitalRepository.save(any(Hospital.class))).thenReturn(hospital);

        // Act
        Hospital verifiedHospital = hospitalService.verifyHospital(hospitalId);

        // Assert
        assertTrue(verifiedHospital.getVerified());

        // Verify that findById and save methods were called
        verify(hospitalRepository, times(1)).findById(hospitalId);
        verify(hospitalRepository, times(1)).save(any(Hospital.class));
    }

    // Test case for verifying a hospital when it's not found
    @Test
    void testVerifyHospitalHospitalNotFound() {
        // Arrange
        String hospitalId = "1";

        // Mock
        when(hospitalRepository.findById(hospitalId)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(HospitalNotFoundException.class, () -> hospitalService.verifyHospital(hospitalId));

        // Verify
        verify(hospitalRepository, never()).save(any(Hospital.class));
    }

    // Test case for getting nearby hospitals
    @Test
    public void testGetNearbyHospitals_Success() {
        // Arrange
        Long pincode = 226025L;
        Hospital hospital1 = new Hospital();
        hospital1.setId("1");
        hospital1.setName("Apollo Hospital");
        hospital1.setHospitalType(HospitalType.PRIVATE);
        hospital1.setContactNo(7270043813L);
        hospital1.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226022L));

        Hospital hospital2 = new Hospital();
        hospital2.setId("2");
        hospital2.setName("Medanta Hospital");
        hospital2.setHospitalType(HospitalType.GOVT);
        hospital2.setContactNo(7270043813L);
        hospital2.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226024L));

        hospitalRepository.saveAll(List.of(hospital1, hospital2));

        List<Hospital> nearbyHospitals = List.of(hospital1, hospital2);

        // Mock
        when(hospitalRepository.findByAddressPincodeBetween(eq(226005L), eq(226045L))).thenReturn(nearbyHospitals);

        // Act
        List<Hospital> hospitals = hospitalService.getNearbyHospitals(pincode);

        // Assert
        assertNotNull(hospitals);
        assertEquals(2, hospitals.size());
    }

    @Test
    void testGetAllHospitals() {
        // Arrange
        List<Hospital> expectedHospitals = new ArrayList<>();
        Hospital hospital1 = new Hospital();
        hospital1.setId("1");
        hospital1.setName("Apollo Hospital");
        hospital1.setHospitalType(HospitalType.PRIVATE);
        hospital1.setContactNo(7270043813L);
        hospital1.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226022L));
       
        Hospital hospital2 = new Hospital();
        hospital2.setId("2");
        hospital2.setName("MEDANTA Hospital");
        hospital2.setHospitalType(HospitalType.GOVT);
        hospital2.setContactNo(7270043813L);
        hospital2.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226022L));
        
        expectedHospitals.add(hospital1);
        expectedHospitals.add(hospital2);

        // Mock
        when(hospitalRepository.findAll()).thenReturn(expectedHospitals);

        // Act
        List<Hospital> hospitals = hospitalService.getAllHositals();

        // Assert
        assertNotNull(hospitals);
        assertEquals(expectedHospitals.size(), hospitals.size());
        assertEquals(expectedHospitals, hospitals);

        // Verify that findAll was called once
        verify(hospitalRepository, times(1)).findAll();
    }
    
    private static AddHospitalRequest createAddHospitalRequest() {
        AddHospitalRequest request = new AddHospitalRequest();
        request.setName("Apollo Hospital");
        request.setHospitalType("PRIVATE");
        request.setContactNo(7270043813L);
        request.setAddress(new Hospital.Address("Lucknow", "Uttar Pradesh", 226022L));
        return request;
    }

    private static Hospital createHospital() {
        Hospital hospital = new Hospital();
        hospital.setId("1");
        hospital.setName("Apollo Hospital");
        hospital.setHospitalType(HospitalType.PRIVATE);
        hospital.setContactNo(7270043813L);
        hospital.setAddress(new Hospital.Address("City", "Uttar Pradesh", 226022L));
        return hospital;
    }
}