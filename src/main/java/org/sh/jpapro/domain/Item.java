package org.sh.jpapro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tbl-item")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id; // 상품 코드

    @Column(nullable=false,length = 50)
    private String itemNn; //상품명

    @Column(nullable=false,name="item_price")
    private int price; // 가격

    @Column(nullable=false)
    private int stockNumber; // 재고 수량

    @Lob
    @Column(nullable=false)
    private String itemDetail; //제품 상세 설명

    @CreationTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate regDate; // 등록 날짜

    @UpdateTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updateDate;
}
