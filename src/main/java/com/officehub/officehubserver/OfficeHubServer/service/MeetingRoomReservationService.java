package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;

import java.time.LocalDate;
import java.util.List;

public interface MeetingRoomReservationService {
    List<MeetingRoomReservationDto> getAllReservationListByDate(LocalDate reservationDate);
    void bookMeetingRoom(PostMeetingRoomReservationDto postMeetingRoomReservationDto);
    List<MeetingRoomReservationDto> getMeetingRoomReservationListByEmployeeId(Long subscriberId);
    void deleteMeetingRoomReservation(Long reservationId);
}
