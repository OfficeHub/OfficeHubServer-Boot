package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("meetingRoom")
public class MeetingRoomDto {
    private Long roomId;
    private String roomName;
    private int maxPeople;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return "MeetingRoomDto{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
