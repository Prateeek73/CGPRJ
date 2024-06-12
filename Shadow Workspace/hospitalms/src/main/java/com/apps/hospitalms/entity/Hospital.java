package com.apps.hospitalms.entity;

import javax.persistence.*;


import com.apps.hospitalms.constants.HospitalType;

import java.util.Objects;

@Table(name = "hospitals")
@Entity
public class Hospital {
	@GeneratedValue
	@Id
	private Long id;
	@Column(nullable = false)
	private String hospitalName;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HospitalType hospitalType;
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name="addressId")
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public HospitalType getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(HospitalType hospitalType) {
		this.hospitalType = hospitalType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Hospital hospital = (Hospital) o;
		return id.equals(hospital.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}