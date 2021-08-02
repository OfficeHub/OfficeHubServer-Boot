package com.officehub.officehubserver.OfficeHubServer.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.officehub.officehubserver.OfficeHubServer.dto.UserInfoDto;

@Mapper
public interface UserInfoMapper {
	UserInfoDto getUserInfo(int employee_id);
	void addUserInfo(@Param("email") String email, @Param("name") String name, @Param("department") String department, @Param("phone_no") String phone_no, @Param("hire_date") String hire_date, @Param("job_title") String job_title, @Param("position") String position, @Param("gender") String gender, @Param("birth_date") String birth_date, @Param("profile_url") String profile_url);
}
