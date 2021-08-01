package com.muin.graphql.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.muin.graphql.domain.Book;
import com.muin.graphql.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 생성,수정,삭제(create,update,delete)를 담당하는 리졸버입니다.
 * (공통 : Resolver는 Bean으로 등록해서 사용해야하므로 @Component 어노테이션을 사용했습니다.)
 *
 * @author kimhanui
 */
@RequiredArgsConstructor
@Transactional
@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;

    /**
     * 메서드명으로 파라미터를 추정할 수 있게 지으면
     * 파라미터 이름을 하나로 통일하기도 합니다.
     */
    public String saveBook(BookDto bookDto){
        Long id = bookRepository.save(bookDto.toEntity()).getId();
        return "saved:"+id;
    }

    public String updateBook(BookDto bookDto, Long id){
        Book target = bookRepository.findById(id).get();
        target.update(bookDto);
        return "updated:"+id;
    }

    public String deleteBook(Long id){
        bookRepository.deleteById(id);
        return "deleted:"+id;
    }
}