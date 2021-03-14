package com.officehub.officehubserver.OfficeHubServer.dto;

public class NoticeDto {
    private int noticeId;
    private String title;
    private String content;

    public NoticeDto() {}

    public NoticeDto(int noticeId, String title, String content) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
    }

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

    @Override
    public String toString() {
        return "NoticeDto{" +
                "noticeId=" + noticeId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

