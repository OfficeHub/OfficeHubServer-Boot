package com.officehub.officehubserver.OfficeHubServer.dto.entity;

import lombok.Getter;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.time.LocalDate;

@Alias("notice") // mybatis 별칭
@Getter
public class NoticeEntity {
    private int noticeId;
    private int writerId;
    private String title;
    private String content;
    private LocalDate writtenDay;

    public NoticeEntity(int noticeId, int writerId, String title, String content, Date writtenDay) {
        this.noticeId = noticeId;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.writtenDay = writtenDay.toLocalDate();
    }
}

