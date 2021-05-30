package com.officehub.officehubserver.OfficeHubServer.dto;

import com.officehub.officehubserver.OfficeHubServer.dto.entity.NoticeEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonNoticeListDto {
    private List<NoticeEntity> notices;

    public JsonNoticeListDto(List<NoticeEntity> notices){
        this.notices = notices;
    }
}
