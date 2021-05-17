package com.officehub.officehubserver.OfficeHubServer;

import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;

public interface UserInfoInterface {
	UserInfo getUserInfo(int id) throws Exception;
}