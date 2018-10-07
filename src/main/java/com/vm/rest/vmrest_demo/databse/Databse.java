package com.vm.rest.vmrest_demo.databse;

import java.util.HashMap;
import java.util.Map;

import com.vm.rest.vmrest_demo.model.Message;
import com.vm.rest.vmrest_demo.model.Profile;

public class Databse {

	private static Map<Long, Message> msgMap = new HashMap<Long, Message>();
	private static Map<String, Profile> profileMap = new HashMap<String, Profile>();
	/**
	 * @return the msgMap
	 */
	public static Map<Long, Message> getMsgMap() {
		return msgMap;
	}
	/**
	 * @return the profileMap
	 */
	public static Map<String, Profile> getProfileMap() {
		return profileMap;
	}
	
	
}
