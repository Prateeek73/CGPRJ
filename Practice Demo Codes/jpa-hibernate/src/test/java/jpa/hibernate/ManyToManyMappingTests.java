package jpa.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.hibernate.Student.Address;
import jpa.hibernate.Student.Gender;

public class ManyToManyMappingTests {
	private static EntityManager entityManager;

	@BeforeAll
	static void setUpData() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-with-hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Test
	void manyToOneMappingTest() {
		Student studentDavid = new Student();
		studentDavid.setFirstName("David");
		studentDavid.setLastName("Goggins");
		studentDavid.setGender(Gender.MALE);
		studentDavid.setBirthDate(Date.valueOf(LocalDate.parse("1999-07-25")));
		studentDavid.setWantsNewsletter(true);
		studentDavid.setAddress(new Address("Baker Street", "221B", "London"));

		Student studentChris = new Student();
		studentChris.setFirstName("Chris");
		studentChris.setLastName("Bumstead");
		studentChris.setGender(Gender.MALE);
		studentChris.setBirthDate(Date.valueOf(LocalDate.parse("2000-07-25")));
		studentChris.setWantsNewsletter(true);
		studentChris.setAddress(new Address("Harlem street", "13B", "New York"));

		Teacher teacherBruce = new Teacher();
		teacherBruce.setId(1L);
		teacherBruce.setFirstName("Bruce");
		teacherBruce.setLastName("Wayne");	

		Course coursePhysics = new Course();
		coursePhysics.setId(1L);
		coursePhysics.setTitle("Physics");
		coursePhysics.setTeacher(teacherBruce);
		coursePhysics.addStudent(studentDavid);
		coursePhysics.addStudent(studentChris);

		Course courseChemistry = new Course();
		courseChemistry.setId(2L);
		courseChemistry.setTitle("Chemistry");
		courseChemistry.setTeacher(teacherBruce);
		courseChemistry.addStudent(studentDavid);
		
		entityManager.getTransaction().begin();
		entityManager.persist(studentDavid);
		entityManager.persist(studentChris);
//		entityManager.persist(teacherBruce);
		entityManager.persist(coursePhysics);
		entityManager.persist(courseChemistry);
		entityManager.getTransaction().commit();
		entityManager.clear();
		
		Course course1 = entityManager.find(Course.class, 1L);
		Course course2 = entityManager.find(Course.class, 2L);
		
//		Teacher teacher = entityManager.find(Teacher.class, 1L);
//		assertEquals(teacher, teacherBruce);
		
		assertEquals(course1.getStudents().size(), 2);
		assertEquals(course2.getStudents().size(), 1);
		
	}

	@AfterAll
	static void cleanUp() {
		entityManager.close();
	}
}
