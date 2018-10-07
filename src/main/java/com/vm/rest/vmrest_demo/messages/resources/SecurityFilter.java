/*package com.vm.rest.vmrest_demo.messages.resources;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	
	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		
		
	 	
	 	 * if you want to ssecure only specific url, you can have 
	 	 * 
	 	 * if(requestContext.getUriInfo().getPath().contains("secured")) {
			
		}
	 	 * 
		
		List<String> headers = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
	
		if(headers != null && headers.size() > 0) {
			String authtoken = headers.get(0);
		 	authtoken = authtoken.replace(AUTHORIZATION_HEADER_PREFIX, "");
		 	
		 	String decoeString = Base64.decodeAsString(authtoken);
		 	
		 	StringTokenizer stringTokenizer = new StringTokenizer(decoeString, ":");
		 	
		 	String username = stringTokenizer.nextToken();
		 	String password = stringTokenizer.nextToken();
		 	
		 	if(username.equals("vm") && password.equals("123")){
		 		
		 		return;
		 	}
		}
	 	
	 	
	 	Response response = Response.status(Response.Status.UNAUTHORIZED)
	 			.entity("user in not authoeized to access resource")
	 			.build();
	 	
	 	
	 	requestContext.abortWith(response);
	 	
	 	
	 			
	
	}

}
*/