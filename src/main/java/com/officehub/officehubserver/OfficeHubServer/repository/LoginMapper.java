package com.officehub.officehubserver.OfficeHubServer.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;

@Mapper
public interface LoginMapper {
	LoginDto getLogin(Map<String, String> loginInfo);
	void addLogin(@Param("employeeId") int employeeId,@Param("userId") String userId,@Param("password") String password);
}
