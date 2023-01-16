package com.project.shopping.domain.sell;


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
    private String product;  // 상품명
    private String price;  // 판매금액
    private Integer qty;  // 재고수량

    private boolean sale;
    private String oldFile;
    private String olddes1;
    private String olddes2;

    private MultipartFile newphoto;  // 상품대표이미지

    private MultipartFile newdes1;  // 상품상세이미지

    private MultipartFile newdes2;  // 상품상세이미지2



    public Sell toSellEntity(){
        return Sell.builder()
                .sidx(sidx)
                .product(product)
                .price(price)
                .photo(oldFile)
                .des1(olddes1)
                .des2(olddes2)
                .qty(qty)
                .sale(isSale())
                .build();
    }

}
