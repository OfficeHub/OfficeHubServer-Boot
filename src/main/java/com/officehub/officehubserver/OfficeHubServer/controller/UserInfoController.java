package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.UserInfoDatabase;
import com.officehub.officehubserver.OfficeHubServer.UserInfoTest;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {
	
	//이제 id를 현재 로그인된 유저의 데이터로 가져오면 됨(쿠키, 세션 데이터 필요)
	private int id = 0;
	
	
	//이 부분은 web.config같은 따로 설정을 넣어서 수정이 가능하도록 하거나 추후엔 삭제 예정
	private String status = "Test";
	String DBside = "DB";
	String Testside = "Test";
	
	@Operation(summary = "id 기준으로 유저의 정보를 쿼리합니다.")
	@Parameter(description = "대상 유저의 id")
    @GetMapping("/users")
    public UserInfo UserData() throws Exception {
        if (status == DBside) {
            UserInfoDatabase DBstatus = new UserInfoDatabase();
            return DBstatus.getUserInfo(id);
        } else if (status == Testside) {
        	UserInfoTest DBstatus = new UserInfoTest();
        	return DBstatus.getUserInfo(id);
        } else {
            throw new Exception();
        }
    }

}
