package org.sh.jpapro.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 폴더명이 domain : 비즈니스 도메인 객체(소프트웨어가 헤결하려는 문제, 해당 소프트웨어가 다루는 특정 서비스 로직.
    // domain 폴더 안에는 주로 데이터베이스 테이블과 매핑되는 엔티티(Entity) 클래스나,
    // 비즈니스 로직과 관련된 모델(Model) 클래스들이 들어갑니다.
    // 예를 들어, 쇼핑몰 애플리케이션이라면 Product, Order, Customer 같은 클래스들이 들어감.
    //        쉽게 말해, 스프링에서의 domain 폴더는 애플리케이션이 다루는 주요 객체들을 모아두는 곳.

    // 2장 ppt p.42 꼭 확인하라는데 왜?

@Entity // DB의 테이블과 연결 -> DB에서 테이블 생성해줌
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board extends BaseEntity { // Board 테이블을 만드는 클래스 => MySql에 Board 테이블 생성됨.

    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI 지정
    private Long bno; //PK,NN,AI

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false, length = 50)
    private String writer;

    @ColumnDefault("0")
    private int visitcount; //NN

    public void updateVisitcount() {
        this.visitcount++; //이 함수를 부르기만 하면 => 원래 visitcount에 자동으로 +1씩 됨
    }
}
