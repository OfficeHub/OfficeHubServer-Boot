package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<NoticeDto> getNoticeList(int offset, int size) {
        Map<String, Integer> map = new HashMap<>();
        map.put("offset", offset);
        map.put("size", size);
        return noticeMapper.getNoticeList(map);
    }

    public NoticeDto getNoticeById(int noticeId) {
        return noticeMapper.getNoticeById(noticeId);
    }

    @Override
    public void insertNotice(NoticeDto dto) {
        noticeMapper.insertNotice(dto);
    }

    @Override
    public void updateNotice(NoticeDto dto) {
        noticeMapper.updateNotice(dto);
    }

    @Override
    public void deleteNotice(int noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }


}
