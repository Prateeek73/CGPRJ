package jpa.hibernate;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "STUD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
	
	public enum Gender {
		MALE, FEMALE
	}
	
	@Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Address {
        private String street;
        private String number;
        private String city;
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String lastName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@Convert(converter = YesNoBooleanConverter.class)
	private boolean wantsNewsletter;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Embedded
//	@AttributeOverride(name = "street", column = @Column(name = "ST_STREET"))
//    @AttributeOverride(name = "number", column = @Column(name = "ST_NUMBER"))
//    @AttributeOverride(name = "city", column = @Column(name = "ST_CITY"))
	private Address address;
}