package com.hcl.search_update.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.hcl.search_update.model.UserCrudRepo;
import com.hcl.search_update.model.UserEntity;

@Service
@SessionScope
public class LoginService {
	@Autowired
	UserCrudRepo userCrudRepo;
	
	public boolean searchID(Long userId) {
		Iterable<UserEntity> users = userCrudRepo.findAll();
		
		for (UserEntity user : users) {
			if(user.getId().equals(userId)) {
				
				return true;
			}
		}
		return false;
 }
	public void updateUser(String name, String password) {
		UserEntity newUser = new UserEntity();
		newUser.setName(name);
		newUser.setPassword(password);

		userCrudRepo.save(newUser);

	}


	
}
