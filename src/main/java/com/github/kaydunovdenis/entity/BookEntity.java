package com.github.kaydunovdenis.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", updatable = false, nullable = false, insertable = false)
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private int price;
}
