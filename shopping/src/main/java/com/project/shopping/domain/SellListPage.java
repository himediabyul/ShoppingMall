/*
package com.project.shopping.domain;

import com.project.shopping.entity.Sell;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SellListPage {

    private int count;  // 페이지당 게시물 수

    private int page;  // 페이지 번호

    private List<Sell> list;

    private int total; // 총 게시물 수

    private int start; // 페이지리스트 시작번호

    private int end; // 페이지리스트 끝번호

    private boolean prev; // 이전

    private boolean next; // 다음


    public SellListPage(int count, int page, List<Sell> list, int total){

        this.count = count;
        this.page = page;
        this.list = list;
        this.total = total;

    }

    private void calPage(){
        // 페이지 끝번호
        this.end = (int)((Math.ceil(this.page * 1.0) / 5)*5);
        // 페이지 시작번호
        this.start = this.end-4;
        // 전체 페이지의 끝번호
        int realEnd = (int)Math.ceil((this.total * 1.0) / count);
        // 끝번호가 실제 끝번호보다 작아야 현재 끝번호 표시
        this.end = realEnd < this.end ? realEnd : this.end;
        // 이전 페이지
        this.prev = this.start > 1;
        // 다음 페이지
        this.next = this.end < realEnd;



    }
}
*/
