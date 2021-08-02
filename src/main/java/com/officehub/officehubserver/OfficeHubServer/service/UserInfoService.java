package com.officehub.officehubserver.OfficeHubServer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.officehub.officehubserver.OfficeHubServer.dto.SignUpDto;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfoDto;
import com.officehub.officehubserver.OfficeHubServer.repository.UserInfoMapper;

@Service
@Transactional
public class UserInfoService {
	
	private final UserInfoMapper userMapper;
	
	public UserInfoService(UserInfoMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserInfoDto getUserInfo(int employee_id) {
		return userMapper.getUserInfo(employee_id);
	}
	
	public void addUser(SignUpDto dto) {
		userMapper.addUserInfo(dto.getEmail(), dto.getName(), dto.getDepartment(), dto.getPhone_no(), dto.getHire_date(), dto.getJob_title(), dto.getPosition(), dto.getGender(), dto.getBirth_date(), dto.getProfile_url());
	}
}
