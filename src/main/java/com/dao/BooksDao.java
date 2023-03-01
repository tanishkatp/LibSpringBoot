package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.domain.Books;

@Service
public interface BooksDao extends JpaRepository<Books,Integer>{

	
//	@Query(value = "UPDATE 'books' SET 'book_name' =:bn , 'author' =:a WHERE 'book_code' =:bc" , nativeQuery = true)
//	Books updateBookNameAndAuthor(@Param("bc")int bookCode , @Param("bn")String bookName , @Param("a")String author);
	
}
