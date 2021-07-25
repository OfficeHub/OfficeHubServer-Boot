package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class EmailDto {
    private String address;
    private String title;
    private String content;
    private MultipartFile attachment;
}
