package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("meetingRoom")
public class MeetingRoomDto {
    private long roomId;
    private int maxPeople;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
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
                ", maxPeople=" + maxPeople +
                '}';
    }

}
