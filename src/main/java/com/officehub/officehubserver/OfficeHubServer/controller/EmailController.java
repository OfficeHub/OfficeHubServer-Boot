package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;
import com.officehub.officehubserver.OfficeHubServer.service.EmailService;
import com.officehub.officehubserver.OfficeHubServer.service.EmailServiceImpl;
import com.officehub.officehubserver.OfficeHubServer.utils.ApiUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailServiceImpl emailServiceImpl) {
        emailService = emailServiceImpl;
    }

    /**
     * 회원가입 환영 메일 발송하기
     * @param address 발송할 메일주소 (type: String)
     * @return
     */
    @PostMapping("/welcome-mail/{address}")
    public ApiResult<?> sendWelcomeMail(@RequestParam(value = "address") String address,
                                        HttpServletResponse response) {

        try {
            emailService.sendWelcomeMail(address);
        }catch (RuntimeException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ApiUtils.success(null);
    }

}
