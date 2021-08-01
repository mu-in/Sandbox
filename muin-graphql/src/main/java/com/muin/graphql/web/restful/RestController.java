package com.muin.graphql.web.restful;

import com.muin.graphql.domain.Book;
import com.muin.graphql.domain.BookRepository;
import com.muin.graphql.web.graphql.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 기존 REST Api에 사용하던 Controller입니다.
 * - 서비스 레이어 생략했습니다.
 *
 * @author kimhanui
 */
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController // FIXME: 왜이러는지 아시는 분??
public class RestController {

    private final BookRepository bookRepository;

    @GetMapping("/")
    public String index(){
        return "Hello REST API!";
    }

    @GetMapping("/{id}")
    public Book find(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }

    @GetMapping("/all")
    public List<Book> findALl(){
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public String saveBook(BookDto bookDto){
        Long id = bookRepository.save(bookDto.toEntity()).getId();
        return "saved:"+id;
    }

    @PutMapping("/book/{id}")
    public String updateBook(@PathVariable Long id, BookDto bookDto){
        Book target = bookRepository.findById(id).get();
        target.update(bookDto);
        return "updated:"+id;
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable Long id, Book book){
        bookRepository.deleteById(id);
        return "deleted:"+id;
    }
}
