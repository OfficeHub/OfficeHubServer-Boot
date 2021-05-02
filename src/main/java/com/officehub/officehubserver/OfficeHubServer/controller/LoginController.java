package com.officehub.officehubserver.OfficeHubServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;
import com.officehub.officehubserver.OfficeHubServer.service.LoginService;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class LoginController {
	
	private final LoginService loginService;
	private LoginDto matchUser;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@Operation(summary = "userid와 password를 비교하여 로그인 성공 여부를 쿼리합니다.")
	@GetMapping("/login")
    public boolean LoginData(@ApiParam(value = "userid", example = "gildong123")
    						 @RequestParam(value = "userid")String userId,
    						 @ApiParam(value = "Password", example = "12345")
    						 @RequestParam(value = "Password")String Password) {
		
		matchUser = loginService.getLogin(userId, Password);
		
		try {
			if(userId.equals(matchUser.getUserId()) && Password.equals(matchUser.getPassword())) 
			{
				return true;
			}else{
				return false;
			}
		}catch(Exception E) {
			return false;
		}
    }
	
	//로그인 계정 추가 API 작성
	@Operation(summary = "회원가입 시, userid와 password 로그인 정보를 add합니다.")
	@GetMapping("/login/useradd")
	public LoginDto Loginadd(@ApiParam(value = "userid", example = "gildong123")
							 @RequestParam(value = "userid")String userId,
							 @ApiParam(value = "Password", example = "12345")
							 @RequestParam(value = "Password")String Password) {
		return null;
	}
}
