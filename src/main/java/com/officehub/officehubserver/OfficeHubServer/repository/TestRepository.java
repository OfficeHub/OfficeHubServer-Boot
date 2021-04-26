package com.officehub.officehubserver.OfficeHubServer.repository;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestRepository implements NoticeRepository{

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<NoticeDto> getNotices(int offset, int size) {

        List<NoticeDto> list = new ArrayList<>();
        NoticeDto ndto1 = new NoticeDto();
        NoticeDto ndto2 = new NoticeDto();
        NoticeDto ndto3 = new NoticeDto();
        NoticeDto ndto4 = new NoticeDto();
        NoticeDto ndto5 = new NoticeDto();

        try {
            ndto1.setNoticeId(1);
            ndto1.setWriterId(1);
            ndto1.setTitle("공지사항1");
            ndto1.setContent("코로나 때문에 전체 직원 재택근무를 시행하겠습니다.");
            String d1 = "2021-03-01 10:00:00";
            Date date1 = sdf.parse(d1);
            ndto1.setWrittenDay(date1);
            list.add(ndto1);

            ndto2.setNoticeId(2);
            ndto2.setWriterId(1);
            ndto2.setTitle("공지사항2");
            ndto2.setContent("코로나 때문에 전체 직원 월급 삭갑.");
            String d2 = "2021-03-05 11:00:00";
            Date date2 = sdf.parse(d2);
            ndto2.setWrittenDay(date2);
            list.add(ndto2);

            ndto3.setNoticeId(3);
            ndto3.setWriterId(1);
            ndto3.setTitle("공지사항3");
            ndto3.setContent("코로나 때문에 전체 직원 해고.");
            String d3 = "2021-03-02 12:00:00";
            Date date3 = sdf.parse(d3);
            ndto3.setWrittenDay(date3);
            list.add(ndto3);

            ndto4.setNoticeId(4);
            ndto4.setWriterId(1);
            ndto4.setTitle("공지사항4");
            ndto4.setContent("코로나 너무 싫다");
            String d4 = "2021-03-10 13:30:00";
            Date date4 = sdf.parse(d4);
            ndto4.setWrittenDay(date4);
            list.add(ndto4);

            ndto5.setNoticeId(5);
            ndto5.setWriterId(1);
            ndto5.setTitle("공지사항5");
            ndto5.setContent("무야호");
            String d5 = "2021-03-01 15:00:00";
            Date date5 = sdf.parse(d5);
            ndto5.setWrittenDay(date5);
            list.add(ndto5);
        }catch (ParseException e){
            e.printStackTrace();
        }

        List<NoticeDto> result = new ArrayList<>();

        try {
            for(int i=offset; i<(offset+size); i++){
                result.add(list.get(i));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // db연결시 ClassNotFoundException
    @Override
    public NoticeDto getNotice(int noticeId) {
        NoticeDto ndto1 = new NoticeDto();
        try{
            ndto1.setNoticeId(noticeId);
            ndto1.setWriterId(1);
            ndto1.setTitle("공지사항1");
            ndto1.setContent("코로나 때문에 전체 직원 재택근무를 시행하겠습니다.");
            String d1 = "2021-03-01 10:00:00";
            Date date1 = sdf.parse(d1);
            ndto1.setWrittenDay(date1);
        }catch (ParseException e){
            e.printStackTrace();
        }

        return ndto1;
    }
}
