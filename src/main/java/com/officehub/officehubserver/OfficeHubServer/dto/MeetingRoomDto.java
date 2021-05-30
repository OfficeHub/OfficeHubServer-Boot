package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("meetingRoom")
@Getter
@Setter
public class MeetingRoomDto {
    private int roomId;
    private String roomName;
    private int maxPeople;

}
