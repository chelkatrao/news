package com.chelkatrao.news.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "news")
@Entity
public class News extends BaseEntity {

    @Column(name = "comment")
    private String comment;

    @Column(name = "img_url")
    private String imgUrl;

}

