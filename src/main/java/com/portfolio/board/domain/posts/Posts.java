package com.portfolio.board.domain.posts;

import com.portfolio.board.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter//Setter는 하면 안된다.
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)가 @Id 어노테이션과 함께 사용되면,
    //데이터베이스에서 자동으로 생성되는 primary key 값을 사용하여 엔티티 객체를 생성
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;//안써도 자동으로 필드 멤버는 컬럼이 되긴 함.

    //@ManyToOne같은 어노테이션이 다른 테이블로 연결을 시켜주는 역할을 함.

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }//수정할때 변경키 위함.
}