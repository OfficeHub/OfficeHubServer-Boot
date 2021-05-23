package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Getter
@Setter
@Alias("postMeetingRoomReservation")
public class PostMeetingRoomReservationDto {
    private Long roomId;
    private Long subscriberId;
    private int startHour;
    private int endHour;
    private LocalDate reservationDate;
}
