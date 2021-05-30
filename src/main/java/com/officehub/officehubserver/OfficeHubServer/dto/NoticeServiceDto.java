package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NoticeServiceDto {
    private int noticeId;
    private int writerId;
    private String title;
    private String content;
    private LocalDate writtenDay;
}
