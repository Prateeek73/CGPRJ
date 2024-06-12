package jpa.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.hibernate.Student.Address;
import jpa.hibernate.Student.Gender;

public class OneToOneMapping {
	private static EntityManager entityManager;

	@BeforeAll
	static void setUpData() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-with-hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Test
	void oneToOneMappingTest() {
		Course course = new Course();
		course.setId(1L);
		course.setTitle("Physics");
		
		CourseMaterial material = new CourseMaterial();
		material.setId(1L);
		material.setUrl("Nootan Prakasan");
		
	    // First, persist the Course entity
		entityManager.getTransaction().begin();
	    entityManager.persist(course);
	    entityManager.getTransaction().commit();

	    // Now, set the course for the CourseMaterial entity
	    material.setCourse(course);
	    
	    // Persist the CourseMaterial entity
	    entityManager.getTransaction().begin();
	    entityManager.persist(material);
	    entityManager.getTransaction().commit();
	    entityManager.clear();
	    
		CourseMaterial expectedCourseMaterial = entityManager.find(CourseMaterial.class, 1L);
		Course expectedCourse = entityManager.find(Course.class, 1L);
		assertEquals(expectedCourseMaterial.getCourse(), expectedCourse);
	}
	
	@Test
	void failureOnAddingMaterailWithoutCourse() {
		CourseMaterial material = new CourseMaterial();
		material.setId(1L);
		material.setUrl("Nootan Prakasan");
		
		entityManager.getTransaction().begin();
		assertThrows(Exception.class, () -> entityManager.persist(material));
		entityManager.getTransaction().commit();
		entityManager.clear();
		
	}

	@AfterAll
	static void cleanUp() {
		entityManager.close();
	}
}
