package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest(controllers = NoticeController.class)
class NoticeControllerTest {

//    @Autowired
//    private MockMvc mvc;

//    @Autowired
//    private NoticeService noticeService;
//    @Autowired
//    private NoticeController noticeController;

//    @Before
//    public void setUp(){
//        noticeService = mock(NoticeService.class);
//        noticeController = new NoticeController(noticeService);
//        testRepository =
//    }

    @Test
    void getNoticeList() {
        // 성공시
        // 요청한 offset 번째부터 size 만큼 공지사항이 db에 존재할때 해당 공지사항들을
        // JsonNoticeListDto 타입 객체로 응답


    }

    @Test
    void getNoticeByNoticeId() {
        // 성공시
        // 요청한 id가 있을 때 공지사항 NoticeDto 객체 리턴
        // NoticeService.getNoticeById를 했을때 리턴값은 가짜 데이터
//        int noticeId = 1;
//        NoticeDto mockNotice = new NoticeDto();
//        mockNotice.setNoticeId(noticeId);
//        // given
//        given(noticeService.getNoticeById(noticeId)).willReturn(mockNotice);

        // when
//        NoticeDto realNotice = noticeController.getNoticeById(noticeId);

        // then
//        assert(realNotice.getNoticeId() == mockNotice.getNoticeId());

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