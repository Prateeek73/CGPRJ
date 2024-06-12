package com.bean;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CURR")
public class CurrentAccount extends Account {

	private double ODLimit;

	public double getODLimit() {
		return ODLimit;
	}

	public void setODLimit(double oDLimit) {
		this.ODLimit = oDLimit;
	}
}