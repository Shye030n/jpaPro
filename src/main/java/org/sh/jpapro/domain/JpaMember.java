package org.sh.jpapro.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity // 클래스가 데이터베이스에서 테이블로 변환됨
@Data //getter, setter, toString이 자동 생성
@Table(name="tbl_member") //이름이 tbl_table인 테이블로 만든다.
public class JpaMember {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(nullable=false,length=50) //열 정의할 때, null X, 문자열 최대길이<51
    private String name;
    @Column(nullable=false,length=50)
    private String password;
    @Column(nullable=false,length=50)
    private String email;
    private String memo;
    @Column(name="addr")
    private String address;

}
