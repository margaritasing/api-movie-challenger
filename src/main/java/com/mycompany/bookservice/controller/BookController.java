package com.mycompany.bookservice.controller;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.entity.BookEntity;
import com.mycompany.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired//spring plz make the object of bsimpl available to bs interface reference here in controller
    private BookService bookService;

    @PostMapping("/books")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO){
        bookDTO = bookService.addBook(bookDTO);
        ResponseEntity<BookDTO> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBook(){
        List<BookDTO> books = bookService.getAllBook();
        ResponseEntity<List<BookDTO>> responseEntity = new ResponseEntity<>(books, HttpStatus.OK);
        //responseEntity = ResponseEntity.ok(books);
        return responseEntity;
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long bookId){
        bookDTO = bookService.updateBook(bookDTO, bookId);
        ResponseEntity<BookDTO> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/books/{bookId}")
    public ResponseEntity<BookDTO> updateBookPrice(@RequestBody BookDTO bookDTO, @PathVariable Long bookId){
        bookDTO = bookService.updateBookPrice(bookDTO, bookId);
        ResponseEntity<BookDTO> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/books/{bookId}")
    public HttpStatus deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return HttpStatus.NO_CONTENT;
    }

    @GetMapping("/{bookId}")
    private BookEntity getBookById(@PathVariable Long bookId){
        return  bookService.getBookById(bookId);

    }

}
