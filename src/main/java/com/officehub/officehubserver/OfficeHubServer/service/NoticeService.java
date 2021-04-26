package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    List<NoticeDto> getNoticeList(int offset, int size);
    NoticeDto getNoticeById(int noticeId);
    void insertNotice(NoticeDto dto);
    void updateNotice(NoticeDto dto);
    void deleteNotice(int noticeId);
}
