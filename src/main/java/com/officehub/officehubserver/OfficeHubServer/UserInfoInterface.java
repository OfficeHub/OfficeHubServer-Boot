package com.officehub.officehubserver.OfficeHubServer;

import com.officehub.officehubserver.OfficeHubServer.dto.UserInfoDto;

public interface UserInfoInterface {
	UserInfoDto getUserInfo(int id) throws Exception;
}