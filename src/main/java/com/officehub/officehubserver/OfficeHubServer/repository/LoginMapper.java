package com.officehub.officehubserver.OfficeHubServer.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;

@Mapper
public interface LoginMapper {
	LoginDto getLogin(Map<String, String> loginInfo);
	LoginDto addLogin(Map<String, String> loginInfo);
}
