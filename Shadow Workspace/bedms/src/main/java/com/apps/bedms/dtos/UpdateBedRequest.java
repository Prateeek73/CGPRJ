package com.apps.bedms.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateBedRequest extends AddBedRequest{
	
	@NotNull()
	@Min(1)
	private Long bedId;

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

}
