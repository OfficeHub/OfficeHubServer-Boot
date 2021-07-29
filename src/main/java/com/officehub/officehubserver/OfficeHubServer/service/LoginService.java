package com.officehub.officehubserver.OfficeHubServer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.officehub.officehubserver.Authentication.CryptoAlgorithm;
import com.officehub.officehubserver.OfficeHubServer.dto.AddAccountDto;
import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.repository.LoginMapper;

@Service
@Transactional
public class LoginService {
	
	private final LoginMapper loginMapper;
	
	public LoginService(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
	
	public LoginDto getLogin(String user_Id, String Password) {
		Map<String, String> loginInfo = new HashMap<>();
		loginInfo.put("user_Id", user_Id);
		loginInfo.put("Password", Password);
		
		return loginMapper.getLogin(loginInfo);
	}

	public void addLogin(AddAccountDto dto) {
		
		int isEmployee = checkAccount(dto);
		
		if(dto.getEmployeeId() != isEmployee){
			loginMapper.addLogin(dto.getEmployeeId(), dto.getUserId(), dto.getPassword());
		} else {
			throw new IdNotFoundException();
		}
		
	}
	
	public int checkAccount(AddAccountDto dto) {
		
		AddAccountDto Account = loginMapper.checkAccount(dto.getEmployeeId());
		
		if(Account == null) {
			return 0;
		} else {
			return Account.getEmployeeId();
		}
		
	}
	
}
