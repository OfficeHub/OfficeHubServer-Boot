package com.officehub.officehubserver.OfficeHubServer.repository;

import org.apache.ibatis.annotations.Mapper;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;

@Mapper
public interface UserInfoMapper {
	UserInfo getUserInfo(int id);
}
