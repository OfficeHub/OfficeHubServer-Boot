package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.UserInfoTest;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;
import com.officehub.officehubserver.OfficeHubServer.service.UserInfoService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {
	
	private final UserInfoService userService;
	
	public UserInfoController(UserInfoService userService) {
		this.userService = userService;
	}
	
	
	@Operation(summary = "id 기준으로 유저의 정보를 쿼리합니다.")
	 @GetMapping("/userinfo")
    public UserInfo UserData(@ApiParam(value = "사번", example = "0")
    						 @RequestParam(value = "id")int id) {
        return userService.getUserInfo(id);
    }
	
	@Operation(summary = "테스트 완성 후 삭제할 것")
	@GetMapping("/test/users")
    public UserInfo UserData_test() throws Exception {
        try{
            UserInfoTest getUser = new UserInfoTest();
        	return getUser.getUserInfo(0);
        } catch(Exception e){
            throw new Exception();
        }
    }

}
