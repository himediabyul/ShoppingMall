package com.project.shopping.entity;

import lombok.*;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;

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
    private String product;  // 상품명

    @Column
    private String price;  // 판매금액

    @Column
    private Integer qty;  // 재고수량

    @Column
    private String simage;  // 상품대표이미지

    @Column
    private String des1;  // 상품상세이미지 1

    @Column
    private String des2;  // 상품상세이미지 2

    @Column
    private String des3;  // 상품상세이미지 3

    @Column
    private String des4;  // 상품상세이미지 4
}
