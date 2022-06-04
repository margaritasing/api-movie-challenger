package com.mycompany.bookservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="BOOK_TABLE")
@NoArgsConstructor
@Getter
@Setter
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    @Column(length = 50)
    private String name;
    private String description;
    private Double pricePerQty;
    private Double availableQty;
    private String authorName;
    private String authorEmail;
}
