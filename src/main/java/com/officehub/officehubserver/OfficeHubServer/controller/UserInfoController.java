package com.officehub.officehubserver.OfficeHubServer.controller;

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
            @RequestParam(value = "id", defaultValue = "1") int id) throws Exception {
        if (id == 0) {
            return new UserInfo(0, "gildong.hong", "정보전략부", "010-1234-5678", "안녕하세요. 처음입니다.", "여기는 사진 경로");
        } else if (id == 1) {
            return new UserInfo(1, "gildong.kim", "영업부", "010-1111-2222", "안녕하세요. 처음입니다2.", "여기는 사진 경로2");
        } else {
            throw new Exception();
        }
    }

}
