package com.muin.graphql.web.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.muin.graphql.domain.Book;
import com.muin.graphql.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 조회(read)를 담당하는 리졸버입니다.
 * (공통 : Resolver는 Bean으로 등록해서 사용해야하므로 @Component 어노테이션을 사용했습니다.)
 *
 * @author kimhanui
 */
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    public Book getBook(Long id){
        return bookRepository.findById(id).get();
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }
}

