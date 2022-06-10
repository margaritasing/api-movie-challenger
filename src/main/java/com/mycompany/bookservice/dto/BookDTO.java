package com.mycompany.bookservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {

    private Long bookId;
    private String name;
    private String description;
    private Double pricePerQty;
    private Double availableQty;
    private String authorName;
    private String authorEmail;


}
