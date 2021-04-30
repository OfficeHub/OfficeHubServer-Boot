package com.officehub.officehubserver.OfficeHubServer.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = NoticeController.class)
class NoticeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void 공지사항목록조회하기() {

    }

    @Test
    void 공지사항조회하기() {
    }

    @Test
    void 공지사항등록하기() {
    }

    @Test
    void 공지사항수정하기() {
    }

    @Test
    void 공지사항삭제하기() {
    }
}