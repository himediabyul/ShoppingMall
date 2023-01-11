package com.project.shopping.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private boolean sale;  // 품절처리


    private String photo;

    public Sell toSellEntity(){
        return Sell.builder()
                .product(product)
                .price(price)
                .qty(qty)
                .sale(isSale())
                .build();
    }

/*    @OneToMany(mappedBy = "sell", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Photo> photo = new ArrayList<>();

    public void addPhoto(Photo photo){
        this.photo.add(photo);

    }
*/
   /* @Column
    private String simage;  // 상품대표이미지

    @Column
    private String des1;  // 상품상세이미지 1

    @Column
    private String des2;  // 상품상세이미지 2

    @Column
    private String des3;  // 상품상세이미지 3

    @Column
    private String des4;  // 상품상세이미지 4*/
}
