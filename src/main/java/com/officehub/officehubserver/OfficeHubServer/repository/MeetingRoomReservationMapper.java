package com.officehub.officehubserver.OfficeHubServer.repository;

import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MeetingRoomReservationMapper {
    List<MeetingRoomReservationDto> getAllReservationListByDate(LocalDate reservationDate);
    void bookMeetingRoom(PostMeetingRoomReservationDto postMeetingRoomReservationDto);
    int checkReservationOverlap(PostMeetingRoomReservationDto postMeetingRoomReservationDto);
    List<MeetingRoomReservationDto> getMeetingRoomReservationListByEmployeeId(Long subscriberId);
    void deleteMeetingRoomReservation(Long reservationId);
    int getMeetingRoomReservationByReservationId(Long reservationId);
    int getMeetingRoomCountById(Long roomId);
}
