package com.officehub.officehubserver.OfficeHubServer.service;

import com.officehub.officehubserver.OfficeHubServer.dto.MeetingRoomReservationDto;
import com.officehub.officehubserver.OfficeHubServer.dto.PostMeetingRoomReservationDto;

import java.util.List;

public interface MeetingRoomReservationService {
    List<MeetingRoomReservationDto> getAllReservationListByDate(String reservationDate);
    void bookMeetingRoom(PostMeetingRoomReservationDto postMeetingRoomReservationDto);
    List<MeetingRoomReservationDto> getMeetingRoomReservationListByEmployeeId(int subscriberId);
    void deleteMeetingRoomReservation(int reservationId);
}
