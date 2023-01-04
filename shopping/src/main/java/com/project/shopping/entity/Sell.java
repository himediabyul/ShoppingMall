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
@Table(name = "final")
public class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sidx;  // 판매글번호

    @Column
    private String product;  // 상품명

    @Column
    private Integer price;  // 판매금액

    @Column
    private Integer qty;  // 재고수량

    @Column
    private String simage;  // 상품대표이미지

    @Column
    private String description;  // 상품상세이미지
}
