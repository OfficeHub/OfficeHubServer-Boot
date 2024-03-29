package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;
import com.officehub.officehubserver.OfficeHubServer.dto.JsonMeetingRoomReservationListDto;
import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.exception.AlreadyBookedInTimeException;
import com.officehub.officehubserver.OfficeHubServer.exception.BadRequestFormatException;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.exception.WrongTimeRangeException;
import com.officehub.officehubserver.OfficeHubServer.service.MeetingRoomReservationService;
import com.officehub.officehubserver.OfficeHubServer.service.MeetingRoomReservationServiceImpl;
import com.officehub.officehubserver.OfficeHubServer.utils.ApiUtils;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MeetingRoomController {

    private final MeetingRoomReservationService mService;

    public MeetingRoomController(MeetingRoomReservationServiceImpl meetingRoomReservationServiceImpl) {
        this.mService = meetingRoomReservationServiceImpl;
    }


    /**
     * 해당날짜에 예약된 회의실 전체 조회
     * @param reservationDate
     * @return list (type: List<MeetingRoomReservationDto>)
     */
    @GetMapping("/meeting-room-reservations/{reservationDate}")
    public ApiResult<?> getAllReservationListByDate(@PathVariable(value = "reservationDate")
                                                    @ApiParam(value = "pattern: yyyy-MM-dd")
                                                    String reservationDate,
                                                    HttpServletResponse response) {
        List<MeetingRoomReservationDto> list;
        try {
            list = mService.getAllReservationListByDate(reservationDate);
        }catch (BadRequestFormatException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }

        return ApiUtils.success(new JsonMeetingRoomReservationListDto(list));
    }


    /**
     * 회의실 예약
     * @param dto (type: PostMeetingRoomReservationDto)
     */
    @PostMapping("/meeting-room-reservation")
    public ApiResult<?> bookMeetingRoom(@RequestBody PostMeetingRoomReservationDto dto,
                                        HttpServletResponse response) {
        try {
            mService.bookMeetingRoom(dto);
        } catch (WrongTimeRangeException | IdNotFoundException | AlreadyBookedInTimeException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(null);
    }


    /**
     * 예약한 회의실 목록 조회하기
     * @param employeeId
     * @return list (type: List<MeetingRoomReservationDto>)
     */
    @GetMapping("/meeting-room-reservation/{employeeId}")
    public ApiResult<?> getMeetingRoomReservationListByEmployeeId(@PathVariable(value = "employeeId") int employeeId,
                                                                  HttpServletResponse response) {
        List<MeetingRoomReservationDto> list;
        try {
            list = mService.getMeetingRoomReservationListByEmployeeId(employeeId);
        } catch (IdNotFoundException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(new JsonMeetingRoomReservationListDto(list));
    }


    /**
     * 회의실 예약 취소
     * @param reservationId
     */
    @DeleteMapping("/meeting-room-reservation/{reservationId}")
    public ApiResult<?> deleteMeetingRoomReservation(@PathVariable(value = "reservationId") int reservationId,
                                                     HttpServletResponse response) {
        try {
            mService.deleteMeetingRoomReservation(reservationId);
        }catch (IdNotFoundException e) {
            response.setStatus(400);
            return ApiUtils.error(e, 400);
        }
        return ApiUtils.success(null);
    }
}
