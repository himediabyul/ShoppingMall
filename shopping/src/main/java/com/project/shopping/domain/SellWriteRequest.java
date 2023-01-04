package com.project.shopping.domain;


import com.project.shopping.entity.Sell;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SellWriteRequest {

    private String product;  // 상품명

    private Integer price;  // 판매금액

    private Integer qty;  // 재고수량

    private MultipartFile simage;  // 상품대표이미지

    private MultipartFile description;  // 상품상세이미지


    public Sell toSellEntity(){
        return Sell.builder()
                .product(product)
                .price(price)
                .qty(qty)
                .build();
    }

}