package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.UserNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.dto.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserInfoController {

    @GetMapping("/users")
    public UserInfo getUserInfo(@RequestParam(value = "id", defaultValue = "0") int id) {
        if (id == 0) {
            return new UserInfo("zimin", "wlals822@naver.com");
        } else if (id == 1) {
            return new UserInfo("con", "con@kako.com");
        } else {
            throw new UserNotFoundException();
        }
    }

}
