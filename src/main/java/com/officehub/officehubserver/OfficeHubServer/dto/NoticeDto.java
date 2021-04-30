package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Alias("notice") // mybatis 별칭
public class NoticeDto {
    private int noticeId;       // 공지사항 고유번호
    private String title;       // 제목
    private String content;     // 내용
    private int writerId;       // 작성자 id
    private Date writtenDay;    // 작성일

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

    public Date getWrittenDay() {
        return writtenDay;
    }

    public void setWrittenDay(Date writtenDay) {
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

