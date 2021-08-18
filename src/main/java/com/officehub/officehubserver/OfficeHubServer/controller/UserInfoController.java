package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.UserInfoTest;
import com.officehub.officehubserver.OfficeHubServer.dto.SignUpDto;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfoDto;
import com.officehub.officehubserver.OfficeHubServer.service.UserInfoService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {
	
	private final UserInfoService userService;
	
	public UserInfoController(UserInfoService userService) {
		this.userService = userService;
	}
	
	/**
	 * 유저 간단 정보 조회(로그인 상태 계정 정보 조회)
	 * @param employee_id
	 */
	
	@Operation(summary = "employee_id 기준으로 유저의 정보를 쿼리합니다.")
	@GetMapping("/userinfo/{emplopyee_id}")
    public UserInfoDto UserData(@ApiParam(value = "사번", example = "0")
    						 @PathVariable(value = "employee_id")int employee_id) {
        return userService.getUserInfo(employee_id);
    }
	
	
	/**
	 * 유저 추가
	 * @param User Object
	 */
	
	@Operation(summary = "User 정보를 employee에 add합니다.")
	@PostMapping("/userinfo/user_info_add")
    public void addUserInfo(@RequestBody SignUpDto dto) {
        userService.addUser(dto);
    }
	
	
	
	
	@Operation(summary = "테스트 완성 후 삭제할 것")
	@GetMapping("/test/users")
    public UserInfoDto UserData_test() throws Exception {
        try{
            UserInfoTest getUser = new UserInfoTest();
        	return getUser.getUserInfo(0);
        } catch(Exception e){
            throw new Exception();
        }
    }

}
