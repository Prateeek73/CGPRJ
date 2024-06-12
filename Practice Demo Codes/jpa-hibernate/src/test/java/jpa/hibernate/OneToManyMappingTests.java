package jpa.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.hibernate.Student.Address;
import jpa.hibernate.Student.Gender;

public class OneToManyMappingTests {
//	private static EntityManager entityManager;
//
//	@BeforeAll
//	static void setUpData() {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-with-hibernate");
//		entityManager = entityManagerFactory.createEntityManager();
//	}
//
//	@Test
//	void oneToManyMappingTest() {
//		List<Course> courseList = new ArrayList<>();
//		courseList.add(new Course(1L, "Physics"));
//		courseList.add(new Course(2L, "Chemistry"));
//		courseList.add(new Course(3L, "Maths"));
//		
//		Teacher teacher = new Teacher();
//		teacher.setId(1L);
//		teacher.setFirstName("Bruce");
//		teacher.setLastName("Wayne");
//		teacher.setCourses(courseList);
//		
//		// Begin a transaction
//		entityManager.getTransaction().begin();
//	
//		// Persist the Teacher entity
//		entityManager.persist(teacher);
//	
//		// Persist each Course entity in the courseList
//		entityManager.persist(courseList.get(0));
//		entityManager.persist(courseList.get(1));
//		entityManager.persist(courseList.get(2));
//	
//		// Commit the transaction to save changes to the database
//		entityManager.getTransaction().commit();
//	
//		// Clear the EntityManager to detach managed entities
//		entityManager.clear();	
//		
//		Teacher teacherFetched = entityManager.find(Teacher.class, 1L);
//		
//		Course course1 = entityManager.find(Course.class, 1L);
//		Course course2 = entityManager.find(Course.class, 2L);
//		Course course3 = entityManager.find(Course.class, 3L);
//		
//		// One teacher can have multiple courses. One to Many Relationship
//		assertEquals(teacher.getId(), teacherFetched.getId());
//		assertEquals(teacher.getFirstName(), teacherFetched.getFirstName());
//		assertEquals(teacher.getLastName(), teacherFetched.getLastName());
//		
//		assertTrue(teacherFetched.getCourses().contains(course1));
//		assertTrue(teacherFetched.getCourses().contains(course2));
//		assertTrue(teacherFetched.getCourses().contains(course3));
//	}
//
//	@AfterAll
//	static void cleanUp() {
//		entityManager.close();
//	}
}
