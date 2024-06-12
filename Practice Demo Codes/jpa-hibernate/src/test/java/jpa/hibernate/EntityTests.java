package jpa.hibernate;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jpa.hibernate.Student.Address;
import jpa.hibernate.Student.Gender;

class EntityTests {

	private static EntityManager entityManager;

	@BeforeAll
	static void setUpData() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-with-hibernate");
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Test
	void basicMappingTest() {
		Student student = new Student();
		student.setId(1L);
		student.setFirstName("David");
		student.setLastName("Goggins");
		student.setGender(Gender.MALE);
		student.setBirthDate(Date.valueOf(LocalDate.parse("1999-07-25")));
		student.setWantsNewsletter(true);
		student.setAddress(new Address("Baker Street", "221B", "London"));

		entityManager.getTransaction().begin();
		entityManager.merge(student);
		entityManager.getTransaction().commit();

		assertEquals(student, entityManager.find(Student.class, 1L));
		entityManager.clear();
	}

	@Nested
	class RelationshipMappingTest {

		@BeforeAll
		static void setUpData() {

			Student studentDavid = new Student();
			studentDavid.setId(1L);
			studentDavid.setFirstName("David");
			studentDavid.setLastName("Goggins");
			studentDavid.setGender(Gender.MALE);
			studentDavid.setBirthDate(Date.valueOf(LocalDate.parse("1999-07-25")));
			studentDavid.setWantsNewsletter(true);
			studentDavid.setAddress(new Address("Baker Street", "221B", "London"));

			Student studentChris = new Student();
			studentChris.setId(2L);
			studentChris.setFirstName("Chris");
			studentChris.setLastName("Bumstead");
			studentChris.setGender(Gender.MALE);
			studentChris.setBirthDate(Date.valueOf(LocalDate.parse("2000-07-25")));
			studentChris.setWantsNewsletter(true);
			studentChris.setAddress(new Address("Harlem street", "13B", "New York"));

			Student studentRonny = new Student();
			studentChris.setId(3L);
			studentChris.setFirstName("Ronny");
			studentChris.setLastName("Coleman");
			studentChris.setGender(Gender.MALE);
			studentChris.setBirthDate(Date.valueOf(LocalDate.parse("1990-07-25")));
			studentChris.setWantsNewsletter(true);
			studentChris.setAddress(new Address("Devil's street", "13B", "New York"));

			Teacher teacherBruce = new Teacher();
			teacherBruce.setId(1L);
			teacherBruce.setFirstName("Bruce");
			teacherBruce.setLastName("Wayne");

			Teacher teacherWalter = new Teacher();
			teacherWalter.setId(2L);
			teacherWalter.setFirstName("Walter");
			teacherWalter.setLastName("White");

			Course coursePhysics = new Course();
			coursePhysics.setId(1L);
			coursePhysics.setTitle("Physics");
			coursePhysics.setTeacher(teacherBruce);
//			coursePhysics.addStudent(studentDavid);
//			coursePhysics.addStudent(studentChris);
//			coursePhysics.addStudent(studentRonny);

			Course courseChemistry = new Course();
			courseChemistry.setId(2L);
			courseChemistry.setTitle("Chemistry");
			courseChemistry.setTeacher(teacherWalter);
//			courseChemistry.addStudent(studentDavid);
//			courseChemistry.addStudent(studentChris);

			Course courseMaths = new Course();
			courseMaths.setId(3L);
			courseMaths.setTitle("Maths");
			courseMaths.setTeacher(teacherBruce);
			
			CourseMaterial material = new CourseMaterial();
			material.setId(1L);
			material.setUrl("Nootan Prakasan");
			material.setCourse(courseMaths);
						
			entityManager.getTransaction().begin();
			
			
			//adding students
			entityManager.merge(studentDavid);
			entityManager.merge(studentChris);
			entityManager.merge(studentRonny);
			
			// adding teachers
			entityManager.merge(teacherBruce);
			entityManager.merge(teacherWalter);
		
			// adding courses
			entityManager.merge(coursePhysics);
			entityManager.merge(courseChemistry);
			entityManager.merge(courseMaths);

			//adding course materials 
			entityManager.merge(material);
			
			entityManager.getTransaction().commit();
			entityManager.clear();
		}

		@Test
		void oneToOneMappingTest() {
			CourseMaterial expectedCourseMaterial = entityManager.find(CourseMaterial.class, 1L);
			Course course = entityManager.find(Course.class, 3L);
			assertEquals(expectedCourseMaterial.getCourse(), course);
		}

		@Test
		void oneToManyMappingTest() {
			Teacher teacherExpected = new Teacher();
			teacherExpected.setId(1L);
			teacherExpected.setFirstName("Bruce");
			teacherExpected.setLastName("Wayne");

			Teacher teacherFetched = entityManager.find(Teacher.class, 1L);

			// One teacher can have multiple courses. One to Many Relationship
			assertEquals(teacherFetched.getId(), 1L);
			assertEquals(teacherFetched.getFirstName(), teacherExpected.getFirstName());
			assertEquals(teacherFetched.getLastName(), teacherExpected.getLastName());
			assertEquals(teacherFetched.getCourses().size(), 2);

		}

		@Test
		void manyToOneMappingTest() {
			Course course1 = entityManager.find(Course.class, 1L);
			Course course2 = entityManager.find(Course.class, 3L);

			// Multiple courses can have a single mapped teacher. Many to One Relationship
			assertEquals(course1.getTeacher(), course2.getTeacher());
		}

		@Test
		void failureOnAddingCourseWithoutTeacher() {
			Course course = new Course();
			course.setId(4L);
			course.setTitle("Physical Education");
			assertThrows(Exception.class, () -> entityManager.persist(course));
		}

		@Test
		void biDirectionalMappingTest() {
			oneToManyMappingTest();
			manyToOneMappingTest();
			failureOnAddingCourseWithoutTeacher();
		}

		@Test
		void manyToManyMappingTest() {
			Course physicsCourse = entityManager.find(Course.class, 1L);	
			physicsCourse.addStudent(entityManager.find(Student.class, 1L));
			physicsCourse.addStudent(entityManager.find(Student.class, 2L));
			
			entityManager.getTransaction().begin();
			entityManager.merge(physicsCourse);
			entityManager.getTransaction().commit();
			entityManager.clear();
			
			Course courseWithMultipleStudents = entityManager.find(Course.class, 1L);
			assertEquals(courseWithMultipleStudents.getStudents().size(), 2);

		}
	}

	@AfterAll
	static void cleanUp() {
		entityManager.close();
	}
}