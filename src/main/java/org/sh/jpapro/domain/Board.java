package org.sh.jpapro.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity // DB의 테이블과 연결 -> DB에서 테이블 생성해줌
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board { // Board 테이블을 만드는 클래스 => MySql에 Board 테이블 생성됨.

    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI 지정
    private Long bno; //PK,NN,AI

    private String title;
    private String content;
    private String writer;
    private Date postdate;
    private int visitcount; //NN
}
