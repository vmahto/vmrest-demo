package com.vm.rest.vmrest_demo.messages.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/secure")
public class Securedresource {

	@GET
	public String test() {
		
		return "Got from secure";
	}
	
}
