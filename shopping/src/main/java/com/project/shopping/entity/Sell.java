package com.project.shopping.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "sell")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sidx;  // 판매글번호

    @Column
    private String category;  // 카테고리

    @ManyToOne
    @JoinColumn(name = "writer")
    private Member writer;

    private String phone;

    @Column
    private String product;  // 상품명

    @Column
    private String price;  // 판매금액

    @Column
    private String description; // 상세내용

    @Column
    private boolean sale;  // 품절처리

    @Column
    private String photo;  // 상품대표이미지

    @Column
    private String des1;  // 상품상세이미지 1

    @Column(insertable = false, updatable = false)
    private LocalDate regdate;  // 상품 등록일

    @Column(insertable = false)
    private LocalDate updatedate;  // 상품 수정일

}
