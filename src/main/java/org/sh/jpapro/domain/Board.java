package org.sh.jpapro.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity // DB의 테이블과 연결 -> DB에서 테이블 생성해줌
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Board { // Board 테이블을 만드는 클래스 => MySql에 Board 테이블 생성됨.

    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AI 지정
    private Long bno; //PK,NN,AI

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1024)
    private String content;

    @Column(nullable = false, length = 50)
    private String writer;

    @CreationTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date postdate;

    @ColumnDefault("0")
    private int visitcount; //NN
}
