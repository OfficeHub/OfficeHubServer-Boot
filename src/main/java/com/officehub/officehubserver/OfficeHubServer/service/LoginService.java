package com.officehub.officehubserver.OfficeHubServer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.officehub.officehubserver.Authentication.CryptoAlgorithm;
import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;
import com.officehub.officehubserver.OfficeHubServer.repository.LoginMapper;

@Service
@Transactional
public class LoginService {
	private final LoginMapper loginMapper;
	
	
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	public LoginDto getLogin(String userId, String Password) {
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("userId", userId);
		loginInfo.put("Password",Password);
//		loginInfo.put("Password", CryptoAlgorithm.getEncrypt_test(Password));
		return loginMapper.getLogin(loginInfo);
	}
	
	public LoginDto addLogin(int employeeId, String userId, String Password) {
		Map<String, String> addLoginInfo = new HashMap<>();
		addLoginInfo.put("userId", userId);
		addLoginInfo.put("Password", CryptoAlgorithm.getEncrypt_test(Password));
		return loginMapper.addLogin(addLoginInfo);
	}
}
