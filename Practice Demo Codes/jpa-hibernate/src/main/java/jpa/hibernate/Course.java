package jpa.hibernate;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Course {
	@Id
	private Long id;
	private String title;
	@OneToOne(mappedBy = "course")
	private CourseMaterial material;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
	private Teacher teacher;

	@ManyToMany
	@JoinTable(name = "STUDENTS_COURSES", 
			joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"), 
			inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
	private List<Student> students = new ArrayList<>();

	public void addStudent(Student student) {
		this.students.add(student);
	}
}