package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<NoticeDto> getNoticeList(int offset, int size) throws IndexOutOfBoundsException{
        int totalCountOfNotices = noticeMapper.getCountOfNotices();  // 공지사항 총 개수

        if (totalCountOfNotices <= offset) {
            // 출력하고자하는 결과가 db의 데이터들의 범위를 넘어갈시 에러 발생
            throw new IndexOutOfBoundsException("index is out of range");
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("offset", offset);
        map.put("size", size);
        return noticeMapper.getNoticeList(map);
    }

    public NoticeDto getNoticeById(int noticeId) throws IdNotFoundException{
        NoticeDto noticeDto = noticeMapper.getNoticeById(noticeId);

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
            if (noticeDto == null) {
                throw new IdNotFoundException("current id is not found");
        }

        return noticeDto;
    }

    @Override
    public void insertNotice(NoticeDto dto) {

        noticeMapper.insertNotice(dto);
    }

    @Override
    public void updateNotice(NoticeDto dto) throws IdNotFoundException{
        NoticeDto noticeDto = noticeMapper.getNoticeById(dto.getNoticeId());

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
        if (noticeDto == null) {
            throw new IdNotFoundException("current id is not found");
        }

        noticeMapper.updateNotice(dto);
    }

    @Override
    public void deleteNotice(int noticeId) {
        NoticeDto noticeDto = noticeMapper.getNoticeById(noticeId);

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
        if (noticeDto == null) {
            throw new IdNotFoundException("current id is not found");
        }

        noticeMapper.deleteNotice(noticeId);
    }

}
