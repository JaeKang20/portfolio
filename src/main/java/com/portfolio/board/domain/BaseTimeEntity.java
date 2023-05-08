package com.portfolio.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass//이 클래스를 상속받으면 필드들도 column으로 인식
@EntityListeners(AuditingEntityListener.class)//Auditing기능 사용
public abstract class BaseTimeEntity {

    @CreatedDate//생성일
    private LocalDateTime createdDate;

    @LastModifiedDate//수정일
    private LocalDateTime modifiedDate;

}