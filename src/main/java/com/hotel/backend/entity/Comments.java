package com.hotel.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "comments")
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( nullable = false)
    private String content;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="board_sn")
    private Board board;

    @Column(name = "board_sn", insertable = false, updatable = false)
    private Long boardSn; // 변경된 부분

    @ManyToOne
    @JoinColumn(name="userId")
    private Member member;

    @Column(name = "userId", insertable = false, updatable = false)
    private String userId; // 변경된 부분

    @Column(name="comment_status", length = 1)
    private String commentStatus = "N";

//    public String getComment() {
//        return comment;
//    }
//    public void update(String comment){
//        this.comment = comment;
//    }

}
