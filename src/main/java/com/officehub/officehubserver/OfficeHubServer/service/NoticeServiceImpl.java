package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.PostNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PutNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.entity.NoticeEntity;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    public NoticeServiceImpl(NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<NoticeEntity> getNoticeList(int offset, int size) throws IndexOutOfBoundsException{
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

    public NoticeEntity getNoticeById(int noticeId) throws IdNotFoundException{
        NoticeEntity noticeEntity = noticeMapper.getNoticeById(noticeId);

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
        if (noticeEntity == null) {
            throw new IdNotFoundException("current id is not found");
        }

        return noticeEntity;
    }

    @Override
    public void insertNotice(PostNoticeDto dto) {
        String title = dto.getTitle();
        String content = dto.getContent();
        int writerId = dto.getWriterId();
        LocalDate localDate = LocalDate.now();
        NoticeEntity noticeEntity = new NoticeEntity(0, writerId, title, content, Date.valueOf(localDate));
        noticeMapper.insertNotice(noticeEntity);
    }

    @Override
    public void updateNotice(PutNoticeDto dto) throws IdNotFoundException{
        NoticeEntity noticeEntity = noticeMapper.getNoticeById(dto.getNoticeId());

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
        if (noticeEntity == null) {
            throw new IdNotFoundException("current id is not found");
        }

        int noticeId = dto.getNoticeId();
        String title = dto.getTitle();
        String content = dto.getContent();
        LocalDate localDate = LocalDate.now();
        NoticeEntity noticeEntity2 = new NoticeEntity(noticeId, 0, title, content, Date.valueOf(localDate));
        noticeMapper.updateNotice(noticeEntity2);
    }

    @Override
    public void deleteNotice(int noticeId) {
        NoticeEntity noticeEntity = noticeMapper.getNoticeById(noticeId);

        // 파라미터로 받은 id의 데이터가 없을시 에러 발생
        if (noticeEntity == null) {
            throw new IdNotFoundException("current id is not found");
        }

        noticeMapper.deleteNotice(noticeId);
    }

}
