package com.chelkatrao.news.controller;

import com.chelkatrao.news.dto.NewsDto;
import com.chelkatrao.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String news(Model model) {
        model.addAttribute("imgObj", newsService.getNewsList());
        model.addAttribute("obj", new NewsDto());
        return "news";
    }

    @PostMapping("/save-news")
    public ModelAndView saveNews(@ModelAttribute("imgObj") NewsDto newsDto) {
        newsService.saveNews(newsDto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("news");
        modelAndView.addObject("imgObj",newsService.getNewsList());
        modelAndView.addObject("obj", new NewsDto());
        return modelAndView;
    }

}
