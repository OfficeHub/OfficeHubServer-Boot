package com.officehub.officehubserver.OfficeHubServer;


import org.springframework.web.bind.annotation.RequestParam;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfoDto;

public class UserInfoTest implements UserInfoInterface{

	@Override
	public UserInfoDto getUserInfo(@RequestParam(value = "id", defaultValue = "0") int id) throws Exception {
        if (id == 0) {
        	//현재 로그인된 사용자 == DB에 저장된 유저 id값 비교 후, 유저 데이터를 가져오도록 한다
            return new UserInfoDto(id, "gildong.hong_테스트", "정보전략부", "010-1234-5678", "여기는 사진 경로");
        } else {
            throw new Exception();
        }
    }
}
