package com.apps.bedms.service;

//import java.util.List;
//
//import org.hibernate.exception.ConstraintViolationException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.web.client.RestTemplate;
//	
//import com.apps.bedms.dtos.AddBedRequest;
//import com.apps.bedms.entities.Bed;
//import com.apps.bedms.exceptions.InvalidBedStatus;
//import com.apps.bedms.repository.IBedRepository;
//import com.apps.bedms.utilities.BedUtil;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;

//@SpringBootTest
class BedServiceTest {
//	private BedService service;
//	private IBedRepository repository;
//
//	@BeforeEach
//	public void setUp() {
//		service = new BedService(repository);
//		BedUtil bedUtil = new BedUtil();
//		bedUtil.setRestTemplate(new RestTemplate());
//		service.setBedUtil(bedUtil);
//	}
//
//	@Test
//	void addBedTest() {
//		AddBedRequest bedRequest = new AddBedRequest();
//		bedRequest.setBedCategory("USUAL_BED");
//		bedRequest.setHospitalId(1L);
//		bedRequest.setChargesPerDay(24.3);
//		assertNotNull(service.add(bedRequest));
//
//		bedRequest.setBedCategory("USUAL_BED");
//		assertNotNull(service.add(bedRequest));
//
//		bedRequest.setBedCategory("ICU_BED");
//		assertNotNull(service.add(bedRequest));
//
//		bedRequest.setBedCategory("OXYGEN_BED");
//		assertNotNull(service.add(bedRequest));
//
//		bedRequest.setBedCategory("VENTITLATOR_BED");
//		assertNotNull(service.add(bedRequest));
//
//		bedRequest.setBedCategory("VENTITLATOR_BEDS");
//		assertThrows(InvalidBedStatus.class, () -> service.add(bedRequest));
//
//		bedRequest.setChargesPerDay(-25.4);
//		assertThrows(ConstraintViolationException.class, () -> service.add(bedRequest));
//
//		List<Bed> beds = ((BedService) service).getAllBeds();
//		assertNotNull(beds);
//		assertEquals(beds, 4);
//	}
//
}
