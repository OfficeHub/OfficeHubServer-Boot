package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeMapper;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(controllers = NoticeController.class)
class NoticeControllerTest {

//    @Autowired
//    private MockMvc mvc;

    private NoticeService noticeService;
    private NoticeController noticeController;

    @Before
    public void setUp(){
        noticeService = mock(NoticeService.class);
        noticeController = new NoticeController(noticeService);
    }

    @Test
    void 공지사항목록조회하기() {

    }

    @Test
    void 공지사항조회하기() {
        // 성공시
        // 요청한 id가 있을 때 공지사항 NoticeDto 객체 리턴
        // NoticeService.getNoticeById를 했을때 리턴값은 가짜 데이터
        int noticeId = 1;
        NoticeDto mockNotice = new NoticeDto();
        mockNotice.setNoticeId(noticeId);
        // given
        given(noticeService.getNoticeById(noticeId)).willReturn(mockNotice);

        // when
        NoticeDto realNotice = noticeController.getNotice(noticeId);

        // then
        assert(realNotice.getNoticeId() == mockNotice.getNoticeId());

        // 실패시
        // 요청한 id가 없으면 예외가 발생한다
        // given

        // when

        // then

    }

    @Test
    void 공지사항등록하기() {
    }

    @Test
    void 공지사항수정하기() {
    }

    @Test
    void 공지사항삭제하기() {
    }
}