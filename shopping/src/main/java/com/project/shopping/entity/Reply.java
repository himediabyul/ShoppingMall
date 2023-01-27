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
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;

    @Column
    private Integer sidx;

    @Column
    private String reply;

    @ManyToOne
    @JoinColumn(name = "replyer")
    private Member replyer;

    @Column
    private LocalDate replydate;

    @Column
    private LocalDate updatedate;



}
