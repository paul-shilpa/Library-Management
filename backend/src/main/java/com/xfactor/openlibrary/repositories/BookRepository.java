package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByisbn(String isbn);

    List<Book> findBytitleAndIsbn(String name, String isbn);

}