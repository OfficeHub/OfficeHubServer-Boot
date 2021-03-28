package com.officehub.officehubserver.OfficeHubServer.repository;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;

import java.text.ParseException;
import java.util.List;

public interface NoticeRepository {

    List<NoticeDto> getNotices(int offset, int size) throws ParseException;
}
