package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.time.LocalDate;

@Alias("meetingRoomReservation")
@Getter
@Setter
public class MeetingRoomReservationDto {
    private int reservationId;
    private int roomId;
    private int subscriberId;
    private int startHour;
    private int endHour;
    private LocalDate reservationDate;

    public MeetingRoomReservationDto(int reservationId, int roomId, int subscriberId, int startHour, int endHour, Date reservationDate) {
        this.reservationId = reservationId;
        this.roomId = roomId;
        this.subscriberId = subscriberId;
        this.startHour = startHour;
        this.endHour = endHour;
        this.reservationDate = reservationDate.toLocalDate();
    }
}
