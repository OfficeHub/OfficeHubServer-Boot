package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Alias("meetingRoomReservation")
public class MeetingRoomReservationDto {
    private Long reservationId;
    private Long roomId;
    private Long subscriberId;
    private int startHour;
    private int endHour;
    private LocalDate reservationDate;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "MeetingRoomReservationDto{" +
                "reservationId=" + reservationId +
                ", roomId=" + roomId +
                ", subscriberId=" + subscriberId +
                ", startHour=" + startHour +
                ", endHour=" + endHour +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
