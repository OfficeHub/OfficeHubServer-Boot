package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;
import com.officehub.officehubserver.OfficeHubServer.dto.JsonNoticeListDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PutNoticeDto;
import com.officehub.officehubserver.OfficeHubServer.dto.entity.NoticeEntity;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeServiceImpl;
import com.officehub.officehubserver.OfficeHubServer.utils.ApiUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
                                        @RequestParam(value = "size") int size,
                                      HttpServletResponse response) {
        List<NoticeEntity> list;
        try {
             list = noticeService.getNoticeList(offset, size);
        } catch (IndexOutOfBoundsException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(new JsonNoticeListDto(list));
    }

    /**
     * 공지사항 상세보기
     * @param noticeId 공지 PK
     * @return 공지 객체(type: NoticeDto)
     */
    @GetMapping("/notice/{noticeId}")
    public ApiResult<?> getNoticeById(@PathVariable(value = "noticeId") int noticeId,
                                      HttpServletResponse response) {
        NoticeEntity nDto;
        try {
            nDto = noticeService.getNoticeById(noticeId);
        } catch (IdNotFoundException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(nDto);
    }

    /**
     * 공지사항 추가
     * @param dto (type: PostNoticeDto)
     */
    @PostMapping("/notice")
    public ApiResult<?> insertNotice(@RequestBody PostNoticeDto dto){
        noticeService.insertNotice(dto);
        return ApiUtils.success(null);
    }

    /**
     * 공지사항 수정
     * @param dto (type: PutNoticeDto)
     */
    @PutMapping("/notice")
    public ApiResult<?> updateNotice(@RequestBody PutNoticeDto dto,
                                     HttpServletResponse response){
        try {
            noticeService.updateNotice(dto);
        } catch (IdNotFoundException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(null);
    }

    /**
     * 공지사항 삭제
     * @param noticeId 공지 PK
     */
    @DeleteMapping("/notice/{noticeId}")
    public ApiResult<?> deleteNotice(@PathVariable(value = "noticeId") int noticeId,
                                     HttpServletResponse response){
        try {
            noticeService.deleteNotice(noticeId);
        } catch (IdNotFoundException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(null);
    }
}

