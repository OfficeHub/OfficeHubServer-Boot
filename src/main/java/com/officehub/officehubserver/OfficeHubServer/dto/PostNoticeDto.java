package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * NoticeController 에서만 사용하는 Request 전용 클래스입니다
 */
@Getter
@Setter
@ToString
public class PostNoticeDto {
    private String title;
    private String content;
    private int writerId;
}
