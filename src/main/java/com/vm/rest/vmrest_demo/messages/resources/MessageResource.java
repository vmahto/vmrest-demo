package com.vm.rest.vmrest_demo.messages.resources;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.vm.rest.vmrest_demo.model.Message;
import com.vm.rest.vmrest_demo.model.exception.AppException;
import com.vm.rest.vmrest_demo.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService msgSvc = new MessageService();

	@GET
	public Collection<Message> getMessages() {

		return msgSvc.getmessages();
	}

	/*@GET
	@Path("/{messageid}")
	public Message getMessages(@PathParam("messageid") long messageid) throws AppException {
		Message msg = null;
		msg = msgSvc.getMessage(messageid);

		return msg;
	}*/

	@GET
	@Path("/{messageid}")
	public Response getMessages(@PathParam("messageid") long messageid) throws AppException {
		Message msg = null;
		
		msg = msgSvc.getMessage(messageid);
		
		return Response.status(Status.FOUND) .entity(msg) .build();
	}
	
	@POST
	public Message addMessage(Message message) {

		return msgSvc.addMessage(message);
	}

	/*
	 * Recomended One
	 * 
	 * @POST public Response addMessage(Message message, @Context UriInfo
	 * uriInfo) {
	 * 
	 * Message message2 = msgSvc.addMessage(message); String newId =
	 * String.valueOf(message2.getId()); URI location =
	 * uriInfo.getAbsolutePathBuilder().path(newId).build(); return
	 * Response.created(location) .entity(message2) .build(); }
	 */

	@PUT
	@Path("/{messageid}")
	public Message updateMessage(@PathParam("messageid") long msgId,
			Message message) {

		message.setId(msgId);
		return msgSvc.updateMessage(message);
	}

	@DELETE
	@Path("/{messageid}")
	public void deleteMessage(@PathParam("messageid") long msgId) {

		msgSvc.removeMessage(msgId);
	}

}
