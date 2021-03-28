package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.UserNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {

    @Operation(summary = "id 기준으로 유저의 정보를 쿼리합니다.")
    @GetMapping("/users")
    public UserInfo getUserInfo(
            @Parameter(description = "대상 유저의 id")
            @RequestParam(value = "id", defaultValue = "0") int id) {
        if (id == 0) {
            return new UserInfo("zimin", "wlals822@naver.com");
        } else if (id == 1) {
            return new UserInfo("con", "con@kako.com");
        } else {
            throw new UserNotFoundException();
        }
    }

}
