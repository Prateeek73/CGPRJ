package com.apps.bedms.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.apps.bedms.constants.BedCategory;
import com.apps.bedms.constants.BedStatus;

@Entity
@Table(name = "beds")
public class Bed implements Comparable<Bed> {
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BedCategory category;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BedStatus status;
	@Column(nullable = false, name = "charges")
	@Min(value = 0, message = "Charges per day cannot be 0 or less")
	private Double chargesPerDay;
	@Column(nullable = false, name = "hospital_id")
	@Min(value = 1, message = "Hospital id cannot be 0 or less")
	private Long hospitalId;

	public Long getId() {
		return id;
	}

	public BedCategory getCategory() {
		return category;
	}

	public void setCategory(BedCategory category) {
		this.category = category;
	}

	public BedStatus getStatus() {
		return status;
	}

	public void setStatus(BedStatus status) {
		this.status = status;
	}

	public Double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(Double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, chargesPerDay, hospitalId, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bed other = (Bed) obj;
		return category == other.category && Objects.equals(chargesPerDay, other.chargesPerDay)
				&& Objects.equals(hospitalId, other.hospitalId) && Objects.equals(id, other.id)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "Bed [id=" + id + ", category=" + category + ", status=" + status + ", chargesPerDay=" + chargesPerDay
				+ ", hospitalId=" + hospitalId + "]";
	}

	@Override
	public int compareTo(Bed o) {
		if (this.getId().equals(o.getId()))
			return 1;
		return 0;
	}
}
