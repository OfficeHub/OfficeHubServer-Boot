package com.officehub.officehubserver.OfficeHubServer;

import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;

public class UserInfoDatabase implements UserInfoInterface{

	@Override
	public UserInfo getUserInfo(int id) {
		// TODO Auto-generated method stub
		return new UserInfo(0, "gildong.hong", "정보전략부", "010-1234-5678", "데이터 베이스는 이걸로!", "여기는 사진 경로");
	}
	
}
