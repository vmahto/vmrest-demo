package com.vm.rest.vmrest_demo.model.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenricExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		return Response.status(Status.NOT_FOUND).entity("Unknown error occur on server").build();
	}


}
