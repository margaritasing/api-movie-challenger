package com.mycompany.bookservice.service.impl;

import com.mycompany.bookservice.dto.BookDTO;
import com.mycompany.bookservice.entity.BookEntity;
import com.mycompany.bookservice.repository.BookRepository;
import com.mycompany.bookservice.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public BookDTO addBook(BookDTO bookDTO) {
        //convert DTO to ENTITY
        BookEntity bookEntity = new BookEntity();
        BeanUtils.copyProperties(bookDTO, bookEntity);//all dto date will be set to entity
        bookEntity = bookRepository.save(bookEntity);
        BeanUtils.copyProperties(bookEntity, bookDTO);//convert entity to dto
        return bookDTO;
    }

    //full update
    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setAuthorEmail(bookDTO.getAuthorEmail());
            be.setAuthorName(bookDTO.getAuthorName());
            be.setAvailableQty(bookDTO.getAvailableQty());
            be.setDescription(bookDTO.getDescription());
            be.setName(bookDTO.getName());
            be.setPricePerQty(bookDTO.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    //update - only update price
    @Override
    public BookDTO updateBookPrice(BookDTO bookDTO, Long bookId) {
        Optional<BookEntity> optEntity = bookRepository.findById(bookId);
        BookEntity be = null;
        if(optEntity.isPresent()){
            be = optEntity.get();
            be.setPricePerQty(bookDTO.getPricePerQty());
            be = bookRepository.save(be);
        }
        BeanUtils.copyProperties(be, bookDTO);
        return bookDTO;
    }

    @Override
    public List<BookDTO> getAllBook() {

        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookDTO> bookDtos = null;

        if(bookEntities != null && !bookEntities.isEmpty()){// not null & not empty
            bookDtos = new ArrayList<>();
            BookDTO dto = null;
            for(BookEntity be : bookEntities){
                dto = new BookDTO();
                BeanUtils.copyProperties(be, dto);
                bookDtos.add(dto);
            }
        }
        return bookDtos;
    }

    @Override
    public BookEntity getBook(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }
}
