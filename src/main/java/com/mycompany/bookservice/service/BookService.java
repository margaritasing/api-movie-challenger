package com.mycompany.bookservice.service;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public BookDTO addBook(BookDTO bookDTO);
    public BookDTO updateBook(BookDTO bookDTO, Long bookId);
    public void deleteBook(Long bookId);
    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId);
    public List<BookDTO> getAllBook();
    public BookEntity getBookById(Long bookId);
}
