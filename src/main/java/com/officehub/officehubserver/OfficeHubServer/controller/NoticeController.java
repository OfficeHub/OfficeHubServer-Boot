package com.officehub.officehubserver.OfficeHubServer.controller;

import com.officehub.officehubserver.OfficeHubServer.dto.NoticeDto;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NoticeController {

    @Data
    public class JsonNoticeList{
        private List<NoticeDto> notices;

        public JsonNoticeList(List<NoticeDto> notices){
            this.notices = notices;
        }
    }

    @GetMapping("/notice")
    @ResponseBody
    public JsonNoticeList getNoticeList(){
        List<NoticeDto> list = new ArrayList<NoticeDto>();
        NoticeDto ndto1 = new NoticeDto();
        NoticeDto ndto2 = new NoticeDto();
        NoticeDto ndto3 = new NoticeDto();

        ndto1.setNoticeId(1);
        ndto1.setTitle("코로나 공지사항");
        ndto1.setContent("코로나 때문에 전체 직원 재택근무를 시행하겠습니다.");
        list.add(ndto1);

        ndto2.setNoticeId(2);
        ndto2.setTitle("사무실 확장 공 공지사항");
        ndto2.setContent("다음주 사무실 확장 공사가 예정되있습니다.");
        list.add(ndto2);

        ndto3.setNoticeId(3);
        ndto3.setTitle("주차시설 공지사항");
        ndto3.setContent("주차시설 확장 공사로 인해 일주일간 사용을 금지합니다.");
        list.add(ndto3);

        return new JsonNoticeList(list);
    }
}

