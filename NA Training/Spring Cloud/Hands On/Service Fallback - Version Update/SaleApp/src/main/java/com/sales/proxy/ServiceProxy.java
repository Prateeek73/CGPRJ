package com.sales.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ProductApp", url = "http://localhost:8071/")
public interface ServiceProxy {

	@GetMapping(value = "/getInfo")
	public String getDetails();

}