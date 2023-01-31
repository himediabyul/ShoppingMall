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
public class SellEditRequest {

    private Integer sidx;
    private Integer writer;  // 작성자

    private String category;  // 카테고리
    private String product;  // 상품명
    private String price;  // 판매금액

    private String description;

    private boolean sale;
    private String oldFile;
    private String olddes1;

    private MultipartFile newphoto;  // 상품대표이미지

    private MultipartFile newdes1;  // 상품상세이미지




    public Sell toSellEntity(){
        return Sell.builder()
                .sidx(sidx)
                .writer(Member.builder().uidx(writer).build())
                .category(category)
                .product(product)
                .price(price)
                .description(description)
                .photo(oldFile)
                .des1(olddes1)
                .sale(isSale())
                .build();
    }

}
