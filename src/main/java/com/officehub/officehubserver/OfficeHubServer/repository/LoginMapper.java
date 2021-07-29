package com.officehub.officehubserver.OfficeHubServer.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.officehub.officehubserver.OfficeHubServer.dto.AddAccountDto;
import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;

@Mapper
public interface LoginMapper {
	LoginDto getLogin(Map<String, String> loginInfo);
	void addLogin(@Param("employee_Id") int employee_Id,@Param("user_Id") String user_Id,@Param("password") String password);
	AddAccountDto checkAccount(@Param("employee_Id") int employee_Id);
}
