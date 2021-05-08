package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
import java.util.Date;

@Alias("notice") // mybatis 별칭
public class NoticeDto {
    private int noticeId;
    private String title;
    private String content;
    private int writerId;
    private LocalDate writtenDay;

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public LocalDate getWrittenDay() {
        return writtenDay;
    }

    public void setWrittenDay(LocalDate writtenDay) {
        this.writtenDay = writtenDay;
    }

    @Override
    public String toString() {
        return "NoticeDto{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerId=" + writerId +
                ", writtenDay=" + writtenDay +
                '}';
    }
}

