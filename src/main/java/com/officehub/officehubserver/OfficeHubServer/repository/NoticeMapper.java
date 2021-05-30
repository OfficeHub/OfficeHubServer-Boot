package com.officehub.officehubserver.OfficeHubServer.repository;

import com.officehub.officehubserver.OfficeHubServer.dto.entity.NoticeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    List<NoticeEntity> getNoticeList(Map<String, Integer> map);
    NoticeEntity getNoticeById(int noticeId);
    void insertNotice(NoticeEntity dto);
    void updateNotice(NoticeEntity dto);
    void deleteNotice(int noticeId);
    int getCountOfNotices();
}
