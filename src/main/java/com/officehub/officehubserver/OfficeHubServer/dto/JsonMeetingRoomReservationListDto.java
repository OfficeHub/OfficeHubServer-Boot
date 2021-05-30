package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonMeetingRoomReservationListDto {
    private List<MeetingRoomReservationDto> meetingRoomReservations;

    public JsonMeetingRoomReservationListDto(List<MeetingRoomReservationDto> meetingRoomReservations) {
        this.meetingRoomReservations = meetingRoomReservations;
    }
}
