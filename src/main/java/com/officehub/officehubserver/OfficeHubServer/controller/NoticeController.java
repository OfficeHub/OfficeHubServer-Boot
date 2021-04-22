package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.repository.NoticeRepository;
import com.officehub.officehubserver.OfficeHubServer.repository.TestRepository;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeServiceImpl noticeService) {
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

    /**
     * Test 공지 목록 출력
     * @param offset
     * @param size
     * @return
     * @throws ParseException
     */
    @ApiOperation(value = "임시 공지목록 출력", notes = "총 테스트 데이터 : 5개")
    @GetMapping("/test/notices")
    public JsonNoticeList getTestNoticeList(@ApiParam(value = "시작 순서", example = "0")
                                        @RequestParam(value = "offset") int offset,
                                        @ApiParam(value = "공지 총개수", example = "5")
                                        @RequestParam(value = "size") int size) throws ParseException {
        NoticeRepository testRepository = new TestRepository();

        return new JsonNoticeList(testRepository.getNotices(offset, size));
    }

    /**
     * Test 공지 상세 정보 출력
     * @param noticeId
     * @return
     */
    @ApiOperation(value = "임시 공지상세정보 출력", notes = "총 테스트 데이터 : 1개")
    @GetMapping("/test/notice")
    public NoticeDto getTestNotice(@RequestParam(value = "noticeId") int noticeId) {
        NoticeRepository testRepository = new TestRepository();
        NoticeDto ndto = testRepository.getNotice(noticeId);

        return ndto;
    }

    /**
     * 공지 목록 출력
     * @param offset
     * @param size
     * @return
     * @throws ParseException
     */
    @ApiOperation(value = "공지목록 출력")
    @GetMapping("/notices")
    public JsonNoticeList getNoticeList(@ApiParam(value = "시작 순서")
                                        @RequestParam(value = "offset") int offset,
                                        @ApiParam(value = "공지 총개수")
                                        @RequestParam(value = "size") int size) throws ParseException {
        List<NoticeDto> list = noticeService.getNoticeList(offset, size);

        return new JsonNoticeList(list);
    }

    /**
     * 공지사항 상세보기
     * @param noticeId
     * @return
     */
    @GetMapping("/notice/{noticeId}")
    public NoticeDto getNotice(@PathVariable(value = "noticeId") int noticeId) {
        return noticeService.getNoticeById(noticeId);
    }

    /**
     * 공지사항 추가
     * @param dto
     */
    @PostMapping("/notice")
    public void insertNotice(@RequestBody NoticeDto dto){
        noticeService.insertNotice(dto);
    }

    /**
     * 공지사항 수정
     * @param dto
     */
    @PutMapping("/notice")
    public void updateNotice(@RequestBody NoticeDto dto){
        noticeService.updateNotice(dto);
    }

    /**
     * 공지사항 삭제
     * @param noticeId
     */
    @DeleteMapping("/notice/{noticeId}")
    public void deleteNotice(@PathVariable(value = "noticeId") int noticeId){
        noticeService.deleteNotice(noticeId);
    }
}

