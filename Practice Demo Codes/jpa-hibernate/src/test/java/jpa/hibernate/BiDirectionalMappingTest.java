package jpa.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BiDirectionalMappingTest {
	private static EntityManager entityManager;

	@BeforeAll
	static void setUpData() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-with-hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Test
	void biDirectionalMappingTest() {
		
		Teacher teacher = new Teacher();
		teacher.setId(1L);
		teacher.setFirstName("Bruce");
		teacher.setLastName("Wayne");
		
		Course coursePhysics = new Course();
		coursePhysics.setId(1L);
		coursePhysics.setTitle("Physics");
		coursePhysics.setTeacher(teacher);

		Course courseChemistry = new Course();
		courseChemistry.setId(2L);
		courseChemistry.setTitle("Chemistry");
		courseChemistry.setTeacher(teacher);

		Course courseMaths = new Course();
		courseMaths.setId(3L);
		courseMaths.setTitle("Maths");
		courseMaths.setTeacher(teacher);
		// Begin a transaction
		entityManager.getTransaction().begin();
	
		// Persist the Teacher entity
		entityManager.persist(teacher);
	
		// Persist the Course entities
		entityManager.persist(coursePhysics);
		entityManager.persist(courseChemistry);
		entityManager.persist(courseMaths);
	
		// Commit the transaction to save changes to the database
		entityManager.getTransaction().commit();
	
		// Clear the EntityManager to detach managed entities
		entityManager.clear();
		Teacher teacherFetched = entityManager.find(Teacher.class, 1L);
		Course course1 = entityManager.find(Course.class, 1L);
		Course course2 = entityManager.find(Course.class, 2L);
		Course course3 = entityManager.find(Course.class, 3L);
		
		// One teacher can have multiple courses. One to Many Relationship
		assertEquals(teacher.getId(), teacherFetched.getId());
		assertEquals(teacher.getFirstName(), teacherFetched.getFirstName());
		assertEquals(teacher.getLastName(), teacherFetched.getLastName());
		
		assertTrue(teacherFetched.getCourses().contains(course1));
		assertTrue(teacherFetched.getCourses().contains(course2));
		assertTrue(teacherFetched.getCourses().contains(course3));	
				
		assertEquals(course1.getTeacher(), course2.getTeacher());
		assertEquals(course2.getTeacher(), course3.getTeacher());

	}
	
	@Test
	void failureOnAddingCourseWithoutTeacher() {
		Course course = new Course();
		course.setId(4L);
		course.setTitle("Physical Education");
		entityManager.getTransaction().begin();
		assertThrows(Exception.class, () -> entityManager.persist(course));
		entityManager.getTransaction().commit();
		entityManager.clear();		
	}

	@AfterAll
	static void cleanUp() {
		entityManager.close();
	}
}
