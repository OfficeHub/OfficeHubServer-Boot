package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;
import com.officehub.officehubserver.OfficeHubServer.dto.JsonNoticeListDto;
import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeServiceImpl;
import com.officehub.officehubserver.OfficeHubServer.utils.ApiUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeServiceImpl noticeServiceImpl) {
        this.noticeService = noticeServiceImpl;
    }

    /**
     * 공지 목록 출력
     * @param offset 출력할 공지 시작 index
     * @param size 요청 공지 개수
     * @return 공지 목록(type: JsonNoticeList)
     */
    @ApiOperation(value = "공지목록 출력")
    @GetMapping("/notices")
    public ApiResult<?> getNoticeList(@ApiParam(value = "출력할 공지 시작 index")
                                        @RequestParam(value = "offset") int offset,
                                      @ApiParam(value = "요청 공지 개수")
                                        @RequestParam(value = "size") int size) {
        List<NoticeDto> list;
        try {
             list = noticeService.getNoticeList(offset, size);
        } catch (IndexOutOfBoundsException e) {
            // 출력하고자하는 결과가 db의 데이터들의 범위를 넘어갈시 에러 발생(offset이 db에 있는 전 공지 갯수를 넘어갈 때 발생)
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(new JsonNoticeListDto(list));
    }

    /**
     * 공지사항 상세보기
     * @param noticeId 공지 PK
     * @return 공지 객체(type: NoticeDto)
     */
    @GetMapping("/notice/{noticeId}")
    public ApiResult<?> getNoticeById(@PathVariable(value = "noticeId") int noticeId) {
        NoticeDto ndto;
        try {
            ndto = noticeService.getNoticeById(noticeId);
        } catch (IdNotFoundException e) {
            // 파라미터로 받은 id의 데이터가 없을시 에러 발생
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(ndto);
    }

    /**
     * 공지사항 추가
     * @param noticeDto (type: NoticeDto)
     */
    @PostMapping("/notice")
    public ApiResult<?> insertNotice(@RequestBody NoticeDto noticeDto){
        noticeService.insertNotice(noticeDto);
        return ApiUtils.success(null);
    }

    /**
     * 공지사항 수정
     * @param noticeDto (type: NoticeDto)
     */
    @PutMapping("/notice")
    public ApiResult<?> updateNotice(@RequestBody NoticeDto noticeDto){
        try {
            noticeService.updateNotice(noticeDto);
        } catch (IdNotFoundException e) {
            // 파라미터로 받은 id의 데이터가 없을시 에러 발생
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(null);
    }

    /**
     * 공지사항 삭제
     * @param noticeId 공지 PK
     */
    @DeleteMapping("/notice/{noticeId}")
    public ApiResult<?> deleteNotice(@PathVariable(value = "noticeId") int noticeId){
        try {
            noticeService.deleteNotice(noticeId);
        } catch (IdNotFoundException e) {
            // 파라미터로 받은 id의 데이터가 없을시 에러 발생
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(null);
    }
}

