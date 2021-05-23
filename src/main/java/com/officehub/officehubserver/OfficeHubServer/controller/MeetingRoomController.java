package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.ApiResult;
import com.officehub.officehubserver.OfficeHubServer.dto.JsonMeetingRoomReservationListDto;
import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.exception.AlreadyBookedInTimeException;
import com.officehub.officehubserver.OfficeHubServer.exception.IdNotFoundException;
import com.officehub.officehubserver.OfficeHubServer.exception.WrongTimeRangeException;
import com.officehub.officehubserver.OfficeHubServer.service.MeetingRoomReservationService;
import com.officehub.officehubserver.OfficeHubServer.service.MeetingRoomReservationServiceImpl;
import com.officehub.officehubserver.OfficeHubServer.utils.ApiUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MeetingRoomController {

    private final MeetingRoomReservationService mService;

    public MeetingRoomController(MeetingRoomReservationServiceImpl meetingRoomReservationServiceImpl) {
        this.mService = meetingRoomReservationServiceImpl;
    }

    /*
        해당날짜에 예약된 회의실 전체 조회
         */
    @GetMapping("/meeting-room-reservations/{reservationDate}")
    public ApiResult<?> getAllReservationListByDate(@PathVariable(value = "reservationDate")
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate reservationDate) {
        List<MeetingRoomReservationDto> list = mService.getAllReservationListByDate(reservationDate);

        return ApiUtils.success(new JsonMeetingRoomReservationListDto(list));
    }

    /*
    회의실 예약하기(param : 회의실 id, 이름, 예약, 시작시간, 종료 시간)
     */
    @PostMapping("/meeting-room-reservation")
    public ApiResult<?> bookMeetingRoom(@RequestBody PostMeetingRoomReservationDto dto) {
        try {
            mService.bookMeetingRoom(dto);
        } catch (WrongTimeRangeException e1) {
            return ApiUtils.error(e1.getMessage(), 400);
        } catch (AlreadyBookedInTimeException e2) {
            return ApiUtils.error(e2.getMessage(), 400);
        }
        return ApiUtils.success(null);
    }

    /*
    예약한 회의실 목록 조회하기
    employeeId를 세션에서 받아옴
    해당 id 없으면 IdNotFoundException 발생
     */
    @GetMapping("/meeting-room-reservation/{employeeId}")
    public ApiResult<?> getMeetingRoomReservationListByEmployeeId(@PathVariable(value = "employeeId") Long employeeId) {

        List<MeetingRoomReservationDto> list;
        try {
            list = mService.getMeetingRoomReservationListByEmployeeId(employeeId);
        } catch (IdNotFoundException e) {
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(new JsonMeetingRoomReservationListDto(list));
    }

    /*
    회의실 예약 취소(param: reservationId)
    해당 id가 없으면 IdNotFoundException 발생
     */
    @DeleteMapping("/meeting-room-reservation/{reservationId}")
    public ApiResult<?> deleteMeetingRoomReservation(@PathVariable(value = "reservationId") Long reservationId) {

        try {
            mService.deleteMeetingRoomReservation(reservationId);
        }catch (IdNotFoundException e) {
            return ApiUtils.error(e.getMessage(), 400);
        }
        return ApiUtils.success(null);
    }
}
