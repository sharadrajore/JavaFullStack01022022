package com.zensar.endpoints;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "bugfixes")
public class BugFixesCustomActuator {
	
	private Map<String, List<String>> bugFixesByVersionMap = new HashMap<>();
	

	public  BugFixesCustomActuator() {
		bugFixesByVersionMap.put("v1", Arrays.asList ("Invalid status issue", "Application closing not working"));
		bugFixesByVersionMap.put("v2", Arrays.asList ("Window size change not working", "Window minimizing not working"));
	}
	
	
	@ReadOperation
	public Map<String, List<String>> getAllBugFixes (){
		return this.bugFixesByVersionMap;
	}
	
	//  http://localhost:8080/my-actuator/bugfixes/v2 
	
	@ReadOperation
	public List<String>getBugFixesByVersion (@Selector String version) {
		return this.bugFixesByVersionMap.get(version);
	}
	
	@WriteOperation
	public void addBugFixes (@Selector String version, String bugFixes ) {
		bugFixesByVersionMap.put(version, Arrays.asList (bugFixes.split(",")));
	}
	
	@DeleteOperation
	public void deleteBugFixes (@Selector String version) {
		bugFixesByVersionMap.remove(version);
	}
	
	
	

}
