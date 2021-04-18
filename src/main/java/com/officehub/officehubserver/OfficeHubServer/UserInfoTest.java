package com.officehub.officehubserver.OfficeHubServer;


import org.springframework.web.bind.annotation.RequestParam;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;

public class UserInfoTest implements UserInfoInterface{

	@Override
	public UserInfo getUserInfo(
            @RequestParam(value = "id", defaultValue = "0") int id) throws Exception {
        if (id == 0) {
        	//현재 로그인된 사용자 == DB에 저장된 유저 id값 비교 후, 유저 데이터를 가져오도록 한다
            return new UserInfo(id, "gildong.hong", "정보전략부", "010-1234-5678", "안녕하세요. 여기는 테스트 데이터", "여기는 사진 경로");
//        } else if (id == 1) {
//            return new UserInfo(id, "gildong.kim", "영업부", "010-1111-2222", "안녕하세요. 처음입니다2.", "여기는 사진 경로2");
        } else {
            throw new Exception();
        }
    }
}
