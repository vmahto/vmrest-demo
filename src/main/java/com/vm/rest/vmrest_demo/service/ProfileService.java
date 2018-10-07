package com.vm.rest.vmrest_demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vm.rest.vmrest_demo.databse.Databse;
import com.vm.rest.vmrest_demo.model.Profile;

public class ProfileService {

	private Map<String, com.vm.rest.vmrest_demo.model.Profile> profiles = Databse.getProfileMap();
	
	public ProfileService() {
		profiles.put("koushik", new Profile(1L, "koushik", "Koushik", "Kothagal"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
