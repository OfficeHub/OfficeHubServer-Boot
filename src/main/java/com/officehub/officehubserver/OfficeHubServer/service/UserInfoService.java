package com.officehub.officehubserver.OfficeHubServer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;
import com.officehub.officehubserver.OfficeHubServer.repository.UserInfoMapper;

@Service
@Transactional
public class UserInfoService {
	
	private final UserInfoMapper userMapper;
	
	public UserInfoService(UserInfoMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public UserInfo getUserInfo(int id) {
		return userMapper.getUserInfo(id);
	}
}
