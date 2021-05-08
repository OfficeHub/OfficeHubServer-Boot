package com.officehub.officehubserver.OfficeHubServer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.officehub.officehubserver.Authentication.CryptoAlgorithm;
import com.officehub.officehubserver.OfficeHubServer.dto.LoginDto;
import com.officehub.officehubserver.OfficeHubServer.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json; charset=UTF-8")
public class LoginController {
	
	private final LoginService loginService;
	private LoginDto matchUser;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	/**
	 * 로그인 성공 여부 확인 쿼리
	 * @param dto
	 * @return Boolean(로그인 성공 여부)
	 */
	
	@Operation(summary = "userid와 password를 비교하여 로그인 성공 여부를 쿼리합니다.")
	@PostMapping(value = "/getlogin")
    public boolean LoginData(@RequestBody LoginDto dto) {
		
		matchUser = loginService.getLogin(dto.getUserId(), CryptoAlgorithm.getEncrypt_test(dto.getPassword()));
		
		if(matchUser == null) {
			return false;
		}
		if(matchUser.getUserId() == null || matchUser.getPassword() == null) {
			return false;
		}
		
		return true;
		
    }
	
	/**
	 * 로그인 정보 add(회원 가입 시, 일반 사원 정보가 기존에 DB에 요청되어있다는 전제)
	 * @param 로그인 객체
	 */
	
	//로그인 계정 추가 API 작성
	@Operation(summary = "회원가입 시, userid와 password 로그인 정보를 add합니다.")
	@PostMapping(value = "/useradd")
	public void Loginadd(@RequestBody LoginDto dto) {
		
		//인사원장에 employeeID가 없는 사람의 계정을 검색하는 경우 error 떨어지도록 예외처리 필요
		//각 인원당 한계정만 가질 수 있도록 걸러낼 필요 있음 --> 쿼리 한번 더 해야될 듯
		loginService.addLogin(dto);
		
	}
}
