package com.vm.rest.vmrest_demo.service;

import java.util.Collection;
import java.util.Map;

import com.vm.rest.vmrest_demo.databse.Databse;
import com.vm.rest.vmrest_demo.model.Message;

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
	public Message getMessage(long msgId) throws Exception {
		if(msgMap.get(msgId)== null) {
			throw new Exception();
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
