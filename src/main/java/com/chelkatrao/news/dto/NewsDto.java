package com.chelkatrao.news.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class NewsDto {
    private String comment;
    private MultipartFile multipartFile;
}
