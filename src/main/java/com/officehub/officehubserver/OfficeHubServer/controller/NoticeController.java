package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeRepository;
import com.officehub.officehubserver.OfficeHubServer.repository.TestRepository;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    /*
            공지 목록 조회 api Json 응답
             */
    @Data
    public static class JsonNoticeList{
        private List<NoticeDto> notices;

        public JsonNoticeList(List<NoticeDto> notices){
            this.notices = notices;
        }
    }

    /*
    공지 목록 조회 test api
     */
    @ApiOperation(value = "임시 공지목록 출력", notes = "총 테스트 데이터 : 5개")
    @GetMapping("test/notices")
    @ResponseBody
    public JsonNoticeList getTestNoticeList(@ApiParam(value = "시작 순서", example = "0")
                                        @RequestParam(value = "offset") int offset,
                                        @ApiParam(value = "공지 총개수", example = "5")
                                        @RequestParam(value = "size") int size) throws ParseException {
        NoticeRepository testRepository = new TestRepository();

        return new JsonNoticeList(testRepository.getNotices(offset, size));
    }

    /*
    공지 목록 조회 api
     */
    @ApiOperation(value = "공지목록 출력")
    @GetMapping("/notices")
    @ResponseBody
    public JsonNoticeList getNoticeList(@ApiParam(value = "시작 순서", example = "0")
                                        @RequestParam(value = "offset") int offset,
                                        @ApiParam(value = "공지 총개수", example = "3")
                                        @RequestParam(value = "size") int size) throws ParseException {
        List<NoticeDto> list = noticeService.getNoticeList(offset, size);

        return new JsonNoticeList(list);
    }

    /*
    공지 상세 정보 조회 test api
     */
    @ApiOperation(value = "임시 공지상세정보 출력", notes = "총 테스트 데이터 : 1개")
    @GetMapping("test/notice")
    @ResponseBody
    public NoticeDto getTestNotice(@RequestParam(value = "noticeId") int noticeId) {
        NoticeRepository testRepository = new TestRepository();
        NoticeDto ndto = testRepository.getNotice(noticeId);

        return ndto;
    }

    /**
     * 공지 상세 정보 조회 api
     */
    @GetMapping("notice")
    @ResponseBody
    public NoticeDto getNotice(@RequestParam(value = "noticeId") int noticeId) {

        return noticeService.getNoticeById(noticeId);
    }
}

