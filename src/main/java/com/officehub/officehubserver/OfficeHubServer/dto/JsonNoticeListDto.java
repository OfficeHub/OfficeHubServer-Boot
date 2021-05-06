package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonNoticeListDto {
    private List<NoticeDto> notices;

    public JsonNoticeListDto(List<NoticeDto> notices){
        this.notices = notices;
    }
}
