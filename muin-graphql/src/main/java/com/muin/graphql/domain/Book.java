package com.muin.graphql.domain;

import com.muin.graphql.web.graphql.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // FIXME : Long타입은 GraphQL의 Int타입으로 변환될 수 없어서 Integer사용
    private String name;
    private String author;
    private Long pages;

    public void update(BookDto bookDto){
        this.name = bookDto.getName();
        this.author = bookDto.getAuthor();
        this.pages = bookDto.getPages();
    }
}
