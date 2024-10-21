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
