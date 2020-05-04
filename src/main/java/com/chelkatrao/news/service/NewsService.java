package com.chelkatrao.news.service;

import com.chelkatrao.news.dto.NewsDto;
import com.chelkatrao.news.dto.NewsShowDto;
import com.chelkatrao.news.model.News;
import com.chelkatrao.news.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private static final Logger log = LoggerFactory.getLogger(NewsService.class);

    @Autowired
    NewsRepository newsRepository;

    private static String UPLOADED_FOLDER = "src/main/resources/static/images/";

    public void saveNews(NewsDto newsDto) {
        System.getProperty("user.home");
        MultipartFile file = newsDto.getMultipartFile();
        String url = UPLOADED_FOLDER + file.getOriginalFilename();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(url);
            Files.write(path, bytes);
            News news = new News();
            news.setComment(newsDto.getComment());
            news.setImgUrl(file.getOriginalFilename());
            news.setCreateBy("system");
            newsRepository.save(news);
        } catch (IOException e) {
            log.error("error", e);
        }
    }

    public List<NewsShowDto> getNewsList() {
        List<News> newsList = newsRepository.findAll();
        return newsList.stream().map(news -> {
            NewsShowDto newsShowDto = new NewsShowDto();
            newsShowDto.setComment(news.getComment());
            newsShowDto.setImageName(news.getImgUrl());
            return newsShowDto;
        }).collect(Collectors.toList());
    }

}
