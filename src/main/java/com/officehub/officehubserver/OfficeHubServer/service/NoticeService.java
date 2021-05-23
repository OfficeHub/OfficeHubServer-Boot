package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PutNoticeDto;

import java.util.List;

public interface NoticeService {

    List<NoticeDto> getNoticeList(int offset, int size);
    NoticeDto getNoticeById(int noticeId);
    void insertNotice(PostNoticeDto dto);
    void updateNotice(PutNoticeDto dto);
    void deleteNotice(int noticeId);
    int getCountOfNotices();
}
