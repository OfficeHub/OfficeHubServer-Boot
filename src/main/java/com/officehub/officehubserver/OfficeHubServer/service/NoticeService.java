package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.entity.NoticeEntity;
import com.officehub.officehubserver.OfficeHubServer.dto.PostNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PutNoticeDto;

import java.util.List;

public interface NoticeService {

    List<NoticeEntity> getNoticeList(int offset, int size);
    NoticeEntity getNoticeById(int noticeId);
    void insertNotice(PostNoticeDto dto);
    void updateNotice(PutNoticeDto dto);
    void deleteNotice(int noticeId);
}
