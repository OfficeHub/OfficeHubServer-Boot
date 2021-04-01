package com.officehub.officehubserver.OfficeHubServer.dto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeDto {
    private int noticeId;
    private String title;
    private String content;
    private int writerId;
    private Date writeday;

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

    public Date getWriteday() {
        return writeday;
    }

    public void setWriteday(Date writeday) {
        this.writeday = writeday;
    }

    @Override
    public String toString() {
        return "NoticeDto{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writerId=" + writerId +
                ", writeday=" + writeday +
                '}';
    }
}

