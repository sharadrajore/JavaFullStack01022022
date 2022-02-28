package com.zensar.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "my-end")
public class MyEndPoint {
	// http://localhost:8080/my-actuator/my-end  -> My custom endpoint
	
	@ReadOperation
	public String helloEndPoint() {
		return "My custom endpoint";
	}

}
