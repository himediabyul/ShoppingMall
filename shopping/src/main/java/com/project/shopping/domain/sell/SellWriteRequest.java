package com.project.shopping.domain.sell;


import com.project.shopping.entity.Member;
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

    private Integer writer;  // 작성자
    private String product;  // 상품명
    private String price;  // 판매금액
    private String description; // 상세내용

    private MultipartFile photo;  // 상품대표이미지

    private MultipartFile des1;  // 상품상세이미지


    public Sell toSellEntity(){
        return Sell.builder()
                .writer(Member.builder().uidx(writer).build())
                .product(product)
                .price(price)
                .description(description)
                .build();
    }

}
