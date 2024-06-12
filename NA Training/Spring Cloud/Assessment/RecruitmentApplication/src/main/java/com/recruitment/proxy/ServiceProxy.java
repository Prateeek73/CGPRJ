package com.recruitment.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "http://localhost:8090/welcome")
public interface ServiceProxy {
	
	@RequestMapping(value = "/greet")
	public String greeting();
}
