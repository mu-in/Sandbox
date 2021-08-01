package com.muin.graphql.web.graphql;

import com.muin.graphql.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {

    private String name;
    private String author;
    private Long pages;

    public Book toEntity(){
        return Book.builder()
                .name(name)
                .author(author)
                .pages(pages)
                .build();
    }
}
