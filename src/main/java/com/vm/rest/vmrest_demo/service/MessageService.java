package com.vm.rest.vmrest_demo.service;

import java.util.Collection;
import java.util.Map;

import javax.ws.rs.core.Response;

import com.vm.rest.vmrest_demo.databse.Databse;
import com.vm.rest.vmrest_demo.model.Message;
import com.vm.rest.vmrest_demo.model.exception.AppException;

public class MessageService {

	private Map<Long, Message> msgMap = Databse.getMsgMap();
	public MessageService() {
		Message m1 = new Message();
		m1.setId(1);
		m1.setMsg("first msg");
		m1.setDate("10th june 2018");
		
		Message m2 = new Message();
		m2.setId(2);
		m2.setMsg("first msg");
		m2.setDate("10th june 2018");
		msgMap.put(1l, m1);
		msgMap.put(2l, m2);
	}
	public Collection<Message> getmessages() {
		
		return  msgMap.values();
	}
	
	public Message addMessage(Message message) {
		message.setId(msgMap.size() +1);
		msgMap.put(message.getId(), message);
		return message;
	}
	public Message getMessage(long msgId) throws AppException {
		if(msgMap.get(msgId)== null) {
			throw new AppException(Response.Status.BAD_REQUEST.getStatusCode(), 400, "Provided data not sufficient for insertion",
					"Please verify that the feed is properly generated/set", "applink");

		}
		return msgMap.get(msgId);
	}
	public Message updateMessage(Message msg) {
		
		if(msg.getId() <= 0) {
			return null;
		}
		msgMap.put(msg.getId(), msg);
		return msg;
	}
	public void removeMessage(long msgId) {
		msgMap.remove(msgId);
	}
	public static void main(String[] args) {
		
		MessageService messageService = new MessageService();
		System.out.println(messageService.getmessages());
	}
}
