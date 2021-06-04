package com.officehub.officehubserver.OfficeHubServer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.officehub.officehubserver.OfficeHubServer.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Transactional
@AutoConfigureMockMvc
@Slf4j
class NoticeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private WebApplicationContext ctx;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void getNoticeList() throws Exception{
//        /*
//         성공시
//         요청한 offset 번째부터 size 만큼 공지사항이 db에 존재할때 해당 공지사항들 리턴
//         */
//        // given
//        int offset = 0;
//        int size = 2;
//
//        // when
//        mvc.perform(get("/notices")
//                .param("offset", String.valueOf(offset))
//                .param("size", String.valueOf(size)))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(true)));
//
//        /*
//         * 실패시
//         * 요청한 offset이 db에 데이터 범위를 넘어갈때 IndexOutOfBoundsException 발생
//         */
//        // given
//        int wrongOffset = 100;  // 하드코딩
//        int pages = 100;
//
//        // when
//        mvc.perform(get("/notices")
//                .param("offset", String.valueOf(wrongOffset))
//                .param("size", String.valueOf(pages)))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(false)));
    }

    @Test
    void getNoticeById() throws Exception {
//        /*
//        성공시
//        요청한 id가 있을 때 공지사항 NoticeDto 객체 리턴
//         */
//        // given"
//        String testNoticeId = "2";
//        String testNoticeTitle = "공지사항2";
//
//        // when
//        mvc.perform(get("/notice/" + testNoticeId))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(true)))
//                .andExpect(jsonPath("$.response.title", is(testNoticeTitle)));
//
//        /*
//        실패시
//        요청한 id가 없으면 IdNotFoundException 발생
//         */
//        // given
//        String wrongNoticeId = "1";
//
//        // when
//        mvc.perform(get("/notice/1"))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(false)));
    }

    @Test
    void insertNotice() throws Exception {
//        /*
//        성공시
//        응답 json 데이터: success == true
//         */
//        // given
//        PostNoticeDto postNoticeDto = new PostNoticeDto();
//        postNoticeDto.setContent("test");
//        postNoticeDto.setTitle("test");
//        postNoticeDto.setWriterId(1);
//        String jsonRequest =  objectMapper.writeValueAsString(postNoticeDto);
//
//        // when
//        mvc.perform(post("/notice")
//                .content(jsonRequest)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(true)));
    }

    @Test
    void updateNotice() throws Exception{
//        /*
//        성공시
//        응답 json 데이터: success == true
//         */
//        // given
//        int testNoticeId = 2;
//        PutNoticeDto putNoticeDto = new PutNoticeDto();
//        putNoticeDto.setContent("test");
//        putNoticeDto.setTitle("test");
//        putNoticeDto.setNoticeId(testNoticeId);
//        String jsonRequest =  objectMapper.writeValueAsString(putNoticeDto);
//        log.info(jsonRequest);
//        // when
//        mvc.perform(put("/notice")
//                .content(jsonRequest)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(true)));
//
//        /*
//        실패시
//        요청한 id가 없으면 IdNotFoundException 발생
//         */
//        // given
//        int wrongNoticeId = 0;
//        PutNoticeDto wrongPutNoticeDto = new PutNoticeDto();
//        wrongPutNoticeDto.setContent("test");
//        wrongPutNoticeDto.setTitle("test");
//        wrongPutNoticeDto.setNoticeId(wrongNoticeId);
//        String wrongJsonRequest =  objectMapper.writeValueAsString(wrongPutNoticeDto);
//
//        // when
//        mvc.perform(put("/notice")
//                .content(wrongJsonRequest)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(false)))
//                .andExpect(jsonPath("$.apiError.message", is("current id is not found")));
    }

    @Test
    void deleteNotice() throws Exception {
//        /*
//        성공시
//        응답 json 데이터: success == true
//         */
//        // given
//        String testNoticeId = "2";
//
//        // when
//        mvc.perform(delete("/notice/" + testNoticeId))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(true)));
//
//        /*
//        실패시
//        요청한 id가 없으면 IdNotFoundException 발생
//         */
//        // given
//        String wrongNoticeId = "0";
//
//        // when
//        mvc.perform(delete("/notice/" + testNoticeId))
//                .andExpect(status().isOk())  // then
//                .andExpect(jsonPath("$.success", is(false)))
//                .andExpect(jsonPath("$.apiError.message", is("current id is not found")));
    }
}