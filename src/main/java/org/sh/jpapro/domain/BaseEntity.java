package org.sh.jpapro.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass //이 클래스가 수퍼클래스라는 뜻
@EntityListeners(value = {AuditingEntityListener.class}) // 자동으로 listner을 생성해서 만들어 쓴다는 말
@Getter
public class BaseEntity {

    @CreationTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="regdate", updatable=false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="moddate")
    private LocalDate modDate;
}
